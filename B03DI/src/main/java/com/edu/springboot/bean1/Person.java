package com.edu.springboot.bean1;

public class Person
{
	private String name;
	private int age;
	private Notebook notebook;
	
//	인수 생성자를 사용하기위해 기본생성자 생성
	public Person(){}
//	인수 생성자 생성
	public Person(String name, int age, Notebook notebook)
	{
		super();
		this.name = name;
		this.age = age;
		this.notebook = notebook;
	}
	
//	getter / setter
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
	public Notebook getNotebook()
	{
		return notebook;
	}
	public void setNotebook(Notebook notebook)
	{
		this.notebook = notebook;
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Person [name="+ name +", age=" + age + ", notebook=" + notebook + "]";
	}
	
	
}
