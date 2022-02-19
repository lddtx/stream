package com.learn.stream.model;

import java.text.DecimalFormat;
import java.util.function.Function;

interface MyMoneyFormat {
    String format(int i);
}

class MyMoney {
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    /**
     * 需要定义接口
     */
    public void printMoney(MyMoneyFormat moneyFormat) {
        System.out.println("我的存款：" + moneyFormat.format(this.money));
    }

    /**
     * 不需要定义接口
     */
    public void printMoneyBetter(Function<Integer, String> moneyFormat) {
        System.out.println("我的存款：" + moneyFormat.apply(this.money));
    }
}

public class FunctionDemo {
    public static void main(String[] args) {
        MyMoney money = new MyMoney(999999999);
        money.printMoney(i -> new DecimalFormat("#,###").format(i));
        money.printMoneyBetter(i -> new DecimalFormat("#,###").format(i));

        // 函数式接口还支持链式操作
        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
        money.printMoneyBetter(moneyFormat.andThen(s -> "人民币" + s));
    }
}
