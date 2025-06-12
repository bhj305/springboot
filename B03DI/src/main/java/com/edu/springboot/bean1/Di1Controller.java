package com.edu.springboot.bean1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//뱔도의 패키지를 생성하면 컨트롤러로 사용할 수 없음
@Controller
public class Di1Controller
{
	@RequestMapping("/di1")
	@ResponseBody 
	public String home() {
//		스프링 컨테이너 생성 
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		Person person1 = (Person) context.getBean("person1"); // 컨테이너에 미리 생성된 person1 빈을 주입 받음.
		System.out.println(person1); // 디버깅 확인용
		
		Person person2 = context.getBean("person2", Person.class); // 두번째 인자를 통해 타입을 명시하면 주입받은 후 별도의 형변환(Person) 필요 없음 
		System.out.println(person2); // 디버깅 확인용
		
		return "Dependency Injection1 (의존주입1)";
	}
}
