package com.edu.springboot.bean2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//별도의 이름을 정하지 않았으므로, 클래스명의 첫글자를 소문자로 변경한 student 라는 이름으로 빈이 생성됨.
@Component
public class Student
{
	@Value("이순신")
	private String name;
	
	@Value("30")
	private int age;
	
	@Autowired
	@Qualifier("macBook")
	private Computer notebook;

	public Student(){}
	public Student(String name, int age, Computer notebook)
	{
		super();
		this.name = name;
		this.age = age;
		this.notebook = notebook;
	}

	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Computer getNotebook()
	{
		return notebook;
	}

	public void setNotebook(Computer notebook)
	{
		this.notebook = notebook;
	}
	
	@Override
	public String toString()
	{
		return "Person [name="+ name +", age=" + age + ", notebook=" + notebook + "]";
	}
}
