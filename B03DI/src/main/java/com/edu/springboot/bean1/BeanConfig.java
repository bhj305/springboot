package com.edu.springboot.bean1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig
{
//	@Bean 어노테이션을 통해 자바빈 생성, 참조변수명은 별도의 설정이 없으면 메서드명인 person1로 생성됨
	@Bean
	public Person person1() {
		Person person = new Person(); // Person 객체 생성
		person.setName("손오곰");
		person.setAge(11);
		person.setNotebook(new Notebook("LG그램")); //Notebook=> new 로 객체 생성해줘야함.
		
		return person;
	}
	
	@Bean(name="person2") // 미리 name 속성 부여
	public Person ptemp() {
		Person person = new Person("알파고", 20, new Notebook("인텔") ); // Person 객체 생성
		return person;
	}
	
}
