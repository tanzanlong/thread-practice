package com.tan.thread.interrupt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndThreadWithInterrupt extends Thread{
	private static Logger logger = LoggerFactory.getLogger(EndThreadWithInterrupt.class);
	
	@Override
	public void run() {
		for (int i = 0; i < 500000; i++) {
		logger.info(" i="+i+1);
		if(Thread.currentThread().isInterrupted()){
		    return;
		}
		}
		
	}

	public static void main(String[] args) {
	    
	    /**
	     * interrupted 是静态方法，调用会清除当前中断状态
	    
	    Thread.currentThread().interrupt();
        logger.info("thread  " + Thread.interrupted());
        logger.info("thread  " + Thread.interrupted());
         */
        /**
         * isInterrupted 是实例方法，调用不会清除当前中断状态
        */
        Thread.currentThread().interrupt();
        logger.info("thread  " + Thread.currentThread().isInterrupted());
        logger.info("thread  " + Thread.currentThread().isInterrupted()); 

		EndThreadWithInterrupt thread=new EndThreadWithInterrupt();
		thread.start();
		thread.interrupt();
		logger.info("thread  "+Thread.interrupted());
	}
}
