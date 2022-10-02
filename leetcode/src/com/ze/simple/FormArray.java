package com.ze.simple;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ze
 * @creat 2022-09-22 22:43
 */
/*
给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，
其中的整数也互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 */
public class FormArray {
    @Test
    public void test(){
        int [] arr = {91,4,64,78};
        int [][] pieces = {{78},{4,64},{91}};
        System.out.println(canFormArray(arr,pieces));
    }
    /*
    思路：将二维数组的每个首元素存入哈希表中
         遍历一维数组，查看是否存在于哈希表
            若不存在，返回false;
            若存在， 返回下标，遍历pieces[i]，查看pieces[i]是否包含于一维数组
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            index.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length; ) {
            if (!index.containsKey(arr[i])) {
                return false;
            }
            int t = index.get(arr[i]);
            int length = pieces[t].length;
            for (int j = 0; j < length; j++) {
                if (arr[i + j] != pieces[t][j]) {
                    return false;
                }
            }
            i += length;
        }
        return true;
    }
}
