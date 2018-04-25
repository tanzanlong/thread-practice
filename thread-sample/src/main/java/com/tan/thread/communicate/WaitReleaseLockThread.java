package com.tan.thread.communicate;



public class WaitReleaseLockThread {
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
            }
        }}



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

        Object lock = new Object();

        TaskThreadA a = new TaskThreadA(lock);
        a.start();

        TaskThreadB b = new TaskThreadB(lock);
        b.start();

    }

}
