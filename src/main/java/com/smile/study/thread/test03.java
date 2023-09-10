package com.smile.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用Lock和await/signalAll
class Print03 extends Thread{
    private static int count;
    private static Lock lock=new ReentrantLock();
    private static Condition condition= lock.newCondition();
    private int flag;
    private String value;
    public Print03(int flag,String value){
        this.flag=flag;
        this.value=value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            while(count%3!=flag){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(value);
            count++;
            condition.signalAll();
            lock.unlock();
        }
    }
}

public class test03 {
    public static void main(String[] args) {
        new Print03(0,"A").start();
        new Print03(1,"B").start();
        new Print03(2,"C").start();
    }
}
