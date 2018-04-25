package com.tan.thread.communicate;


public class NotifyOneThread {
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

    static class TaskThreadB extends Thread {
        private Object lock;

        public TaskThreadB(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            TaskService service = new TaskService();
            service.testMethod(lock);
        }
    }


    static class TaskThreadC extends Thread {
        private Object lock;

        public TaskThreadC(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            TaskService service = new TaskService();
            service.testMethod(lock);
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
            synchronized (lock) {
                lock.notify();
                lock.notify();
                lock.notify();
                lock.notify();
                lock.notify();
                lock.notify();
                lock.notify();
                lock.notify();
                lock.notify();
            }
        }

    }
    
    
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        TaskThreadA a = new TaskThreadA(lock);
        a.start();

        TaskThreadB b = new TaskThreadB(lock);
        b.start();

        TaskThreadC c = new TaskThreadC(lock);
        c.start();

        Thread.sleep(1000);

        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();

    }
    
}
