package com.edu.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig
{
	@Autowired
    public  myAuthFailureHandler myAuthFailureHandler;
    
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf)->csrf.disable()) // Cross Site Request Forgery 사용안함, 사이트 간 위조 요청
			.cors((cors)->cors.disable()) // Cross-Origin Resource Sharing 사용 안함.
			.authorizeHttpRequests((request) -> request
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
				.requestMatchers("/guest/**").permitAll()
				.requestMatchers("/member/**").hasAnyRole("USER","ADMIN") // 둘 중 하나만 있어도 됨.
				.requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN만 허용
				.anyRequest().authenticated() // 위의 인증이 필요함을 의미
			);
//		Login을 위함
		http.formLogin((formLogin) -> formLogin
				.loginPage("/myLogin.do") // default : login
				.loginProcessingUrl("/myLoginAction.do")
//				.failureUrl("/myError.do") // default : login?error
				.failureHandler(myAuthFailureHandler)
				.usernameParameter("my_id")  // default : username
				.passwordParameter("my_pass") // default : password
				.permitAll());
		
//		Logout을 위함
		http.logout((logout) -> logout
				.logoutUrl("/myLogout.do")
				.logoutSuccessUrl("/")
				.permitAll());
		
//		권한이 부족한 경우
		http.exceptionHandling((expHandling) -> expHandling
				.accessDeniedPage("/denied.do"));
		
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("USER", "ADMIN")
				.build();
		
		// 메모리에 사용자 정보를 담는다.
		return new InMemoryUserDetailsManager(user, admin);
	}

	private PasswordEncoder passwordEncoder()
	{
		// 패스워드 인코더: 패스워드를 저장하기 전 암호화함.
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
