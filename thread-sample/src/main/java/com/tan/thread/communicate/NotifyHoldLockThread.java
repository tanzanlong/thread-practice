package com.tan.thread.communicate;



public class NotifyHoldLockThread {
    static class TaskService {
        public void testMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println("begin wait() ThreadName="
                            + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("  end wait() ThreadName="
                            + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void synNotifyMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println("begin notify() ThreadName="
                            + Thread.currentThread().getName() + " time="
                            + System.currentTimeMillis());
                    lock.notify();
                    Thread.sleep(5000);
                    System.out.println("  end notify() ThreadName="
                            + Thread.currentThread().getName() + " time="
                            + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    static class NotifyThread extends Thread {
        private Object lock;

        public NotifyThread(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            TaskService service = new TaskService();
            service.synNotifyMethod(lock);
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


    
    static class SynNotifyMethodThread extends Thread {
        private Object lock;

        public SynNotifyMethodThread(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            TaskService service = new TaskService();
            service.synNotifyMethod(lock);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        TaskThreadA a = new TaskThreadA(lock);
        a.start();

        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();

        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();

    }


}
