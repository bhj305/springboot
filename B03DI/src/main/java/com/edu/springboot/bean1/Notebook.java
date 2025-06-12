package com.edu.springboot.bean1;

public class Notebook
{
	private String cpu;

	public Notebook(String cpu)
	{
		super();
		this.cpu = cpu;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "Notebook [cpu=" + cpu + "]";
	}
	
}
