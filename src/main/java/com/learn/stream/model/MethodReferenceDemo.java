package com.learn.stream.model;

import java.util.function.*;

class Dog {
    private String name = "哮天犬🐶";

    private int food = 10;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog) {
        System.out.println(dog + "汪汪汪");
    }

    /**
     * 吃狗粮
     *
     * JDK默认会把当前实例传入到非静态方法，参数名为this，位置是第一个；
     *
     * @param num
     * @return 还剩下多少斤
     */
    public int eat(Dog this, int num) {
        System.out.println("吃了：" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString(Dog this) {
        return this.name;
    }
}

public class MethodReferenceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(3);

        // 方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("接收的数据");

        // 静态方法的方法引用
        Consumer<Dog> consumer2 = Dog::bark;
        consumer2.accept(dog);

        // 非静态方法，使用对象实例的方法引用
        // Function<Integer, Integer> function = dog::eat;
        // UnaryOperator<Integer> function = dog::eat;
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下" + function.applyAsInt(2) + "斤");

        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + "斤");

        // 构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象：" + supplier.get());

        // 带参数的构造函数的方法引用
        Function<String, Dog> function2 = Dog::new;
        System.out.println("创建了新对象：" + function2.apply("旺财🐶"));

    }
}
