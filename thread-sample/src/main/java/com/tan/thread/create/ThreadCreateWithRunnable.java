package com.tan.thread.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  class ThreadCreateWithRunnable implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(ThreadCreateWithRunnable.class);
	@Override
	public void run() {
          		logger.info(" ...thread imp runnable running... ");
	}

}
