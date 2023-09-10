package com.smile.study.thread;
//通过线程的独有属性来指定线程
class Print01 extends Thread{
    private static int count=1;
    private static String lock="A";

    public void run(){
        synchronized (lock){
            while(count<30){
                switch (count%3){
                    case 1:
                        System.out.println("A");
                        break;
                    case 2:
                        System.out.println("B");
                        break;
                    case 0:
                        System.out.println("C");
                        break;
                }
                count++;
            }
        }
    }
}
public class test01 {
    public static void main(String[] args) {
        Print01 printA=new Print01();
        Print01 printB=new Print01();
        Print01 printC=new Print01();
        printA.start();
        printB.start();
        printC.start();
    }
}


