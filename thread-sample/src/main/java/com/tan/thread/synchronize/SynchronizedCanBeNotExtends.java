package com.tan.thread.synchronize;


public class SynchronizedCanBeNotExtends {
    static class TaskService {
        synchronized public void serviceMethod() {
            try {
                System.out.println("int TaskService 下一步 sleep begin threadName="
                        + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("int TaskService 下一步 sleep   end threadName="
                        + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    
    
    static class SubTaskService extends TaskService{
        @Override
         public void serviceMethod() { //synchronized
            try {
                System.out.println("int SubTaskService 下一步 sleep begin threadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("int SubTaskService 下一步 sleep   end threadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
                super.serviceMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    

    static class TaskThreadB extends Thread {
        private SubTaskService service;

        public TaskThreadB(SubTaskService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.serviceMethod();
        }
    }


    static class TaskThreadA extends Thread {
        private SubTaskService service;

        public TaskThreadA(SubTaskService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.serviceMethod();
        }
    }
    
    public static void main(String[] args) {
        SubTaskService subRef = new SubTaskService();

        TaskThreadA a = new TaskThreadA(subRef);
        a.setName("A");
        a.start();

        TaskThreadB b = new TaskThreadB(subRef);
        b.setName("B");
        b.start();
    }
}
