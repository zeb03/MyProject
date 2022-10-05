package com.ze.test1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author ze
 * @creat 2022-09-15 22:31
 * 常见函数式接口：
 * Consume<T> 接收数据
 * Supplier<T> 提供数据
 * Function<T> 可接收可提供
 * Predicate<T> 判断数据
 *
 */
public class LambdaTest1 {
    @Test
    public void test1(){
        Spend(100,money-> System.out.println("花费"+money));
        List<String> list = Arrays.asList("10","20","31","00");
        List<String> strings = destString(list, s -> s.contains("0"));
        System.out.println(strings);
        int sum = add(1,() -> 10);
        System.out.println(sum);
    }

    public int add(int i, Supplier<Integer> sup){
        return i + sup.get();
    }
    public List<String> destString(List<String> list, Predicate<String> predicate){
        ArrayList<String> arrayList = new ArrayList<>();
        for(String str : list){
            if(predicate.test(str)){
                arrayList.add(str);
            }
        }
        return arrayList;
    }
    public void Spend(double money, Consumer<Double> con){
        con.accept(money);
    }
}
