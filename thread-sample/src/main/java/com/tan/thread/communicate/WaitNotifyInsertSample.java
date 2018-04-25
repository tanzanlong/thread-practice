package com.tan.thread.communicate;

public class WaitNotifyInsertSample {
    
    static class BackupA extends Thread {

        private DBTools dbtools;

        public BackupA(DBTools dbtools) {
            super();
            this.dbtools = dbtools;
        }

        @Override
        public void run() {
            dbtools.backupA();
        }

    }

    
    static class BackupB extends Thread {

        private DBTools dbtools;

        public BackupB(DBTools dbtools) {
            super();
            this.dbtools = dbtools;
        }

        @Override
        public void run() {
            dbtools.backupB();
        }

    }
    
    
    static class DBTools {

        volatile private boolean prevIsA = false;

        synchronized public void backupA() {
            try {
                while (prevIsA == true) {
                    wait();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("★★★★★");
                }
                prevIsA = true;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized public void backupB() {
            try {
                while (prevIsA == false) {
                    wait();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("☆☆☆☆☆");
                }
                prevIsA = false;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        DBTools dbtools = new DBTools();
        for (int i = 0; i < 20; i++) {
            BackupB output = new BackupB(dbtools);
            output.start();
            BackupA input = new BackupA(dbtools);
            input.start();
        }
    }
}
