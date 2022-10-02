package com.ze.simple;

import org.junit.Test;

/**
 * @author ze
 * @creat 2022-09-20 20:16
 * @Describe 给你一个整数 x ,如果 x 是一个回文整数,返回 true ;否则,返回 false
 */
public class IsPalindrome {
    @Test
    public void test1(){
        int x = -121;
        System.out.println(isPalindrome(x));
    }
    public boolean isPalindrome(int x) {
        int j, i = 0,length = 0;
        int[] nums = new int[10];
        if(x < 0){
            return false;
        }
        while (x != 0) {
            j = x % 10;
            x = x / 10;
            nums[i++] = j;
            length++;
        }
        for (i = 0; i < length / 2; i++) {
            if (nums[i] != nums[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
