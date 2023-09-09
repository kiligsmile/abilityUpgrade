package com.smile.multiThread.syn;

class BuyTicket implements Runnable {
    private int ticktnumbers = 10;
    boolean flag = true; // 外部停止方式
    @Override
    public void run() {
        while (flag) {
            try {
                buy();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private synchronized void buy() throws InterruptedException {
        if (ticktnumbers <= 0) {
            flag = false;
        }
        System.out.println(Thread.currentThread().getName() + "买了第" + ticktnumbers-- + "张票。");
    }
}

public class UnSafeBuyTicket{
    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();
    }
}
