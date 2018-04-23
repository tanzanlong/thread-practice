package com.tan.thread.interrupt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndThreadWithInterrupt extends Thread{
	private static Logger logger = LoggerFactory.getLogger(EndThreadWithInterrupt.class);
	
	@Override
	public void run() {
		for (int i = 0; i < 500000; i++) {
		logger.info(" i="+i+1);
		}
		
	}

	public static void main(String[] args) {
		EndThreadWithInterrupt thread=new EndThreadWithInterrupt();
		
		thread.start();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
