package com.learn.stream.model;

/**
 * 函数式接口要求只有一个方法
 */
@FunctionalInterface
interface MyInterface {
    int doubleNum(int i);

    default int add(int x, int y) {
        System.out.println("begin add...");
        return x + y;
    }
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyInterface myInterface = i -> i*2;

        MyInterface myInterface1 = i -> {
            System.out.println("begin double...");
            return i*2;
        };

        System.out.println(myInterface.doubleNum(2));

        System.out.println(myInterface1.doubleNum(2));

        System.out.println(myInterface.add(1, 2));
    }
}
