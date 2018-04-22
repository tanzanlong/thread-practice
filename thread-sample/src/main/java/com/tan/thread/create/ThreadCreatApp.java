package com.tan.thread.create;

public class ThreadCreatApp {
 public static void main(String[] args) {
	 /**
	  * 实现runnable接口定义线程
	  */
	ThreadCreateWithRunnable threadRun=new ThreadCreateWithRunnable();
	Thread thread=new Thread(threadRun);
	thread.start();
	
	
	
}
}
