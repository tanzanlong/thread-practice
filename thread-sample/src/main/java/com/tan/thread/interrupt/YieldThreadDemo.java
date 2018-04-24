package com.tan.thread.interrupt;

public class YieldThreadDemo {

	static class TaskThread extends Thread{

		@Override
		public void run() {
			long beginTime=System.currentTimeMillis();
			int count=0;
			for (int i = 0; i < 50000000; i++) {
				//Thread.yield();
				count=count+(i+1);
			}
			long endTime=System.currentTimeMillis();
			System.out.println("用时："+(endTime-beginTime));
		}
		
	}
	
	public static void main(String[] args) {
		TaskThread taskThread=new TaskThread();
		taskThread.start();
	}
}
