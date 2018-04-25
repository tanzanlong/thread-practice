package com.tan.thread.synchronize;

public class ThrowExceptionNoLock {

    

    static class TaskThreadB extends Thread {
        private TaskService service;

        public TaskThreadB(TaskService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.testMethod();
        }
    }


    static class TaskThreadA extends Thread {
        private TaskService service;

        public TaskThreadA(TaskService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.testMethod();
        }
    }


    static class TaskService {
        synchronized public void testMethod() {
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("ThreadName=" + Thread.currentThread().getName()
                        + " run beginTime=" + System.currentTimeMillis());
                int i = 1;
                while (i == 1) {
                    if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                        System.out.println("ThreadName=" + Thread.currentThread().getName()
                                + " run   exceptionTime=" + System.currentTimeMillis());
                        Integer.parseInt("a");
                    }
                }
            } else {
                System.out.println("Thread B run Time=" + System.currentTimeMillis());
            }
        }
    }
    
    
    public static void main(String[] args) {
        try {
            TaskService service = new TaskService();

            TaskThreadA a = new TaskThreadA(service);
            a.setName("a");
            a.start();

            Thread.sleep(500);

            TaskThreadB b = new TaskThreadB(service);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
