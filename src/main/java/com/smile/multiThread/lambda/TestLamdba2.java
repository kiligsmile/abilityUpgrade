package com.smile.multiThread.lambda;

public class TestLamdba2 {
    public static void main(String[] args) {
        ILove love=(int a)->{System.out.println("i love you -->"+a);
        };
        love.love(1);
    }
}
interface ILove{
    void love(int a);
}

//class Love implements ILove{
//    @Override
//    public void love(int a) {
//        System.out.println("i love you -->"+a);
//    }
//}