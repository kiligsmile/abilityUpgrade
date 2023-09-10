package com.smile.multiThread.syn;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
class TestLooK2 implements Runnable{
    private int ticktnumbers = 10;
    boolean flag = true; // 外部停止方式

    // 定义lock锁：显示的锁
    // ReentrantLock 可重入锁
    private ReentrantLock lock = new ReentrantLock();
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
    public  void buy(){
        try{
            lock.lock();    //加锁
            if (ticktnumbers <= 0) {
                flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "买了第" + ticktnumbers-- + "张票。");
        }finally {
            lock.unlock();  //解锁
        }
    }
}
public class TestLock {
    public static void main(String[] args) {
        TestLooK2 testLooK2 = new TestLooK2();
        new Thread(testLooK2).start();
        new Thread(testLooK2).start();
        new Thread(testLooK2).start();
    }
}
