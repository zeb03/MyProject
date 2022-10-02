package com.ze.simple;

/**
 * @author ze
 * @creat 2022-09-25 13:34
 */
// 整数数组+1
/*
    知识点: 循环
    while()与for(;(array[i]!=val);i--) 达到一个最终标志即停止，可以获得其下标，并对已经遍历过的数组元素进行修改
    for(;;)可以通过if获得指定下标，主要功能为遍历整个数组
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int notNine = index;
        while(digits[notNine] == 9){
            if(--notNine == -1){
                break;
            }
        }
        if(notNine == index){
            digits[index]++;
        } else if(notNine == -1){
            digits = new int[digits.length + 1];
            digits[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                digits[i] = 0;
            }
        } else{
            digits[notNine]++;
            for (int i = index; i > notNine; i--) {
                digits[i] = 0;
            }
        }
        return digits;
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            for(int i = len - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] %= 10;
                if(digits[i]!=0)
                    return digits;
            }
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;
        }
    }
}
