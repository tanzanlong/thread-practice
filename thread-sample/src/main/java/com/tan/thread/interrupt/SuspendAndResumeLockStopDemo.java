package com.tan.thread.interrupt;

public class SuspendAndResumeLockStopDemo {

	
	static class TaskThread extends Thread{
 
		private long i=0;
		
		@Override
		public void run() {
			while(true){
				i++;
			}
			
		}
		
	} 
	
	static class TaskPrintOutThread extends Thread{
		 
		private long i=0;
		
		@Override
		public void run() {
			while(true){
				i++;
				System.out.println(i);
			}
			
		}
		
	} 
	
	
	public static void main(String[] args) throws InterruptedException {
	/**	TaskThread taskThread=new TaskThread();
		taskThread.start();
		Thread.sleep(1000);
		taskThread.suspend();
		System.out.println("main end");**/
		/**
		 * 程序运行到print内部停止时，同步锁未释放。导致main end打印不出来。
		 */
		TaskPrintOutThread taskThread=new TaskPrintOutThread();
		taskThread.start();
		Thread.sleep(1000);
		taskThread.suspend();
		System.out.println("main end");
		
	}
}
