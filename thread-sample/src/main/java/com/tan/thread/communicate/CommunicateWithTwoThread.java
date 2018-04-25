package com.tan.thread.communicate;

import java.util.ArrayList;
import java.util.List;


public class CommunicateWithTwoThread {
    static class TaskList {
        private List<String> list = new ArrayList<String>();

        public void add() {
            list.add("tan");
        }

        public int size() {
            return list.size();
        }
    }



    static class TaskThreadB extends Thread {
        private TaskList list;

        public TaskThreadB(TaskList list) {
            super();
            this.list = list;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("list.size()="+list.size()+":flag:"+(list.size() == 5));
                    if (list.size() == 5) {
                        System.out.println("==5了，线程b要退出了！");
                        throw new InterruptedException();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class TaskThreadA extends Thread {
        private TaskList list;

    public TaskThreadA(TaskList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
    

    public static void main(String[] args) {
        TaskList list = new TaskList();

        TaskThreadA a = new TaskThreadA(list);
        a.setName("A");
        a.start();

        TaskThreadB b = new TaskThreadB(list);
        b.setName("B");
        b.start();

    }
}
