package com.smile.study.thread;

//使用synchronized和wait/notifyAll
class Print02 extends Thread{
    private static int count;
    private static Object obj=new Object();
    private int flag;
    private String value;
    public Print02(int flag,String value){
        this.flag=flag;
        this.value=value;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (obj){
                while(count%3!=flag){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(value);
                count++;
                obj.notifyAll();
            }
        }
    }
}
public class test02 {
    public static void main(String[] args) {
        new Print02(0,"A").start();
        new Print02(1,"B").start();
        new Print02(2,"C").start();
    }

}
