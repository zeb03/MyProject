package com.ze.test1;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author ze
 * @creat 2022-09-15 20:33
 * @Describe:
 * lambda表达式
 * (参数)->{方法体}
 * 单条语句时括号可省略
 *
 * 要求：函数式接口
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        runnable1.run();
        System.out.println("*********************");
        Runnable runnable2 = ()->{
            System.out.println("2");
        };
        runnable2.run();
    }

    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("1");
        System.out.println("*************");

        Consumer<String> con2 = (String s)-> System.out.println(s);
        con2.accept("2");

        System.out.println("*************");

        Consumer<String> con3 = s-> System.out.println(s);
        con2.accept("3");
    }

    @Test
    public void test3(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(10,4));
        System.out.println("*************");

        Comparator<Integer> comparator1 =(o1,o2)->{
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(2,4));

        System.out.println("*************");

        Comparator<Integer> comparator2 =(o1,o2)-> o1.compareTo(o2);
        System.out.println(comparator2.compare(2,4));
    }
}
