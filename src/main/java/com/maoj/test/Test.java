package com.maoj.test;

public class Test extends Dispatcher{
	
	public Test()
	{
		super("test");
	}
	
	Object test(Object param)
	{
		System.out.println("Object");
		return param;
	}
	
	Object test(String param)
	{
		System.out.println("string param");
		return param;
	}

}
