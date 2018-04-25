package com.tan.thread.communicate;

import java.util.ArrayList;
import java.util.List;


public class WaitInterruptThread {
    static class TaskList {
        private static List<String> list = new ArrayList<String>();

        public static void add() {
            list.add("tan");
        }

        public static int size() {
            return list.size();
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
            try {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        TaskList.add();
                        if (TaskList.size() == 5) {
                            lock.notify();
                            System.out.println("已发出通知！");
                        }
                        System.out.println("添加了" + (i + 1) + "个元素!");
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class TaskThreadA extends Thread {private Object lock;

    public TaskThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (TaskList.size() != 5) {
                    System.out.println("wait begin "
                            + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end  "
                            + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
    

    public static void main(String[] args) {

            try {
                Object lock = new Object();

                TaskThreadA a = new TaskThreadA(lock);
                a.start();

                Thread.sleep(50);

                TaskThreadB b = new TaskThreadB(lock);
                b.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
