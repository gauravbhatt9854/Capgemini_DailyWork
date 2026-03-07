package com.dk;

// 2 methods to create thread in java 

// 1 extend the thread class 
/*
 * class Base {}
 * class Derived extends Base{}
 * Base b = new Base();
 * Derived d = new Derived;
 * 
 * b = d;
 * d = b;
 * 
 * 11 is correct
 * 12 is correct 
 */

class ChildThread extends Thread {
	public ChildThread(ThreadGroup group) {
		super(group, "dummy");
	}

	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("child : " + thread);
		for (int i = 1; i <= 100; i++) {
			System.out.println("child :" + i);
		}
	}
}

class ChildThread2 implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("child2 : " + thread);
		for (int i = 1; i <= 100; i++) {
			System.out.println("child2 :" + i);
		}
	}
}

public class ThreadingBasic {
	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println("main : " + thread);

		ThreadGroup group = new ThreadGroup("DB Threads");

		ChildThread t = new ChildThread(group);
		t.setName("childThread");
		t.setPriority(1);

		t.start(); // will execute run in new thread and return at the same time
		ChildThread2 obj = new ChildThread2();
		Thread t2 = new Thread(group, obj);
		t2.setName("childThread2");
		t2.setPriority(10);
		t2.start();
//		for (int i = 1; i < 5; i++) {
//			ChildThread t3 = new ChildThread();
//			t3.start();
//		}
		for (int i = 1; i <= 100; i++) {
			System.out.println("main :" + i);
		}
		Runnable obj1 = () -> {
			for (int i = 1; i <= 100; i++)
				System.out.println("runnable " + i);
		};
		new Thread(obj1).start();

	}

}
