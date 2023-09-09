package com.smile.multiThread.syn;

import java.util.ArrayList;
import java.util.List;

// 集合线程不安全
public class UnSafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                    //同一时间会存在线程往列表同一位置添加数据，被覆盖掉一些
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(list);
        System.out.println(list.size());
    }
}
 // 这里需要加延时是因为需要等for循环跑完，才能正确读取list长度