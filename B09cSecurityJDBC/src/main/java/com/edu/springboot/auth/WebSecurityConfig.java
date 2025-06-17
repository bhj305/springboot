package com.edu.springboot.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.edu.springboot.B09cSecurityJDBCApplication;
import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig
{

    private final B09cSecurityJDBCApplication b09cSecurityJDBCApplication;
	@Autowired
    public  myAuthFailureHandler myAuthFailureHandler;

    WebSecurityConfig(B09cSecurityJDBCApplication b09cSecurityJDBCApplication) {
        this.b09cSecurityJDBCApplication = b09cSecurityJDBCApplication;
    }
    
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
	
//	DB 연결을 위한 데이터 소스를 자동 주입 받는다.
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT user_id, user_pw, enabled FROM security_admin WHERE user_id = ?") // 사용자가 있는지 먼저 조회
		.authoritiesByUsernameQuery("SELECT user_id, authority FROM security_admin WHERE user_id = ?") // 사용자의 역할을 구함
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
