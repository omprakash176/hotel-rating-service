package com.java8.features.chapter.three;

public class LambdaWithThread {

	public static void main(String[] args) {
		
		Thread t = new Thread(()->{
			{
				for(int i=0;i<10;i++)
				{
					System.out.println("child Thread " + i);
				}
			}
		});
		
		t.start();
		
		for(int i=0;i<10;i++)
		{
			System.out.println("Main Thread " + i);
		}
	}

}
