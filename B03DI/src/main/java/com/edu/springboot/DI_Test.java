package com.edu.springboot;

class Persons {
	String name;
	int age;
	
	
	public Persons()
	{
		System.out.println("Public 생성자 호출됨");
	}

	// 생성자를 private으로 선언하면 외부에서 인스턴스 생성을 할 수 없음.
//	private Persons()
//	{
//		System.out.println("Public 생성자 호출됨");
//	}
	
}

public class DI_Test
{
// 강한 결합(독립성 낮음)
	public static void aPerson() {
		Persons persons1 = new Persons();
		persons1.name = "홍길동";
		persons1.age = 12;
	}
//	약한 결합(private 선언 시 사용할 수 있음)
	public static void aPerson(Persons person2) {
		person2.name = "전우치";
		person2.age = 22;
	}
//	 DI 목적: 객체간의 독립성을 높이고, 결합도를 낮춰 프로그램을 간결하게 만듬.
}
