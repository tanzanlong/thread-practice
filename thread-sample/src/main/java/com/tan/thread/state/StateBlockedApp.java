package com.tan.thread.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**NEW 刚创建还没执行
 * 
 * RUNNABLE start方法执行后，一切准备就绪时
 * 
 * BLOCKED 阻塞
 * 
 * WAITING 无限时间等待
 * 
 * TIMED_WAITING 有限时间等待
 * 
 * TERMINATED 执行完
 * 
 * @author tanzl
 *
 */
public class StateBlockedApp {
	private static Logger logger = LoggerFactory.getLogger(StateBlockedApp.class);
	
 public static void main(String[] args) {
	 Object object=new Object();
	 /**
	  * 初始化状态
	  */
	Thread stateThread=new Thread(new Runnable() {
		@Override
		public void run() {
			synchronized (object) {
				logger.info(" state get the lock");
				try {
					Thread.sleep(300*1000); //TIME WAITING
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	},"state-1");
	stateThread.start();
	 /**
	  * 初始化状态
	  */
	Thread statesThread=new Thread(new Runnable() {
		@Override
		public void run() {
			synchronized (object) {
				logger.info(" state2 get the lock");
			}
		}
	},"state-2");
	
	
	statesThread.start();
	
	
	 
}
}


/**
"state-2" #12 prio=5 os_prio=0 tid=0x000000001ceec000 nid=0x1a54 waiting for monitor entry [0x000000001e89f000]
java.lang.Thread.State: BLOCKED (on object monitor)
	at com.tan.thread.state.StateApp$2.run(StateApp.java:53)
	- waiting to lock <0x00000000d70a5d38> (a java.lang.Object)
	at java.lang.Thread.run(Unknown Source)

Locked ownable synchronizers:
	- None

"state-1" #11 prio=5 os_prio=0 tid=0x000000001dc95800 nid=0x4a28 waiting on condition [0x000000001e79e000]
java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at com.tan.thread.state.StateApp$1.run(StateApp.java:38)
	- locked <0x00000000d70a5d38> (a java.lang.Object)
	at java.lang.Thread.run(Unknown Source)

Locked ownable synchronizers:
	- None
**/