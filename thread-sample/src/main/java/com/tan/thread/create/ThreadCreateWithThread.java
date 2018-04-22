package com.tan.thread.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadCreateWithThread extends Thread {
	private static Logger logger = LoggerFactory.getLogger(ThreadCreateWithThread.class);
	@Override
	public void run() {
		logger.info(" ...thread imp extends thread... ");;
	}
  
}
