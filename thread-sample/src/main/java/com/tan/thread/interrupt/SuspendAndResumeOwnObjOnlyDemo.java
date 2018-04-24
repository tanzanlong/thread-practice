package com.tan.thread.interrupt;

public class SuspendAndResumeOwnObjOnlyDemo {

	
	static class SynchronizedObject{
		
	synchronized public void print(){
		
	System.out.println("begin");
	if(Thread.currentThread().getName().equals("a")){
		System.out.println("a 线程永远suspend了");
		Thread.currentThread().suspend();
	}
	System.out.println("end");
	}	
		
	}
	
	public static void main(String[] args) {
		try{
		final SynchronizedObject obj=new SynchronizedObject();
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				obj.print();
			}
		});
		thread.setName("a");
		thread.start();
		Thread.sleep(1000);
		
		
     Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread2 start");
				System.out.println("thread print被a占有，并且suspend了");
				obj.print();
			}
		});
		thread2.start();
		
		}catch(InterruptedException e){
			
		}
		
	}
}
