package com.ze.string;

import org.junit.Test;

/**
 * author zebii
 * date 2023-01-13 21:13
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        String str = "abcdef";
        char[] chars = str.toCharArray();
        reverseString(chars);
        System.out.println(chars);
    }
}
