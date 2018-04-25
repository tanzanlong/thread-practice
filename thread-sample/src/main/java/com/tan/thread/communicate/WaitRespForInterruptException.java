package com.tan.thread.communicate;


public class WaitRespForInterruptException {
    static class TaskService {
        public void testMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println("begin wait()");
                    lock.wait();
                    System.out.println("  end wait()");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("出现异常了，因为呈wait状态的线程被interrupt了！");
            }
        }
    }


    static class TaskThreadA extends Thread {
        private Object lock;

        public TaskThreadA(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            TaskService service = new TaskService();
            service.testMethod(lock);
        }
    }
    
    public static void main(String[] args) {

        try {
            Object lock = new Object();

            TaskThreadA a = new TaskThreadA(lock);
            a.start();

            Thread.sleep(5000);

            a.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
