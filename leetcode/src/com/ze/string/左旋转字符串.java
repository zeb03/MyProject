package com.ze.string;

import org.junit.Test;

/**
 * author zebii
 * date 2023-01-15 16:02
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        //解法一：切片
//        String str = s.substring(n) + s.substring(0, n);
//        return str;

        //解法二：
//        StringBuilder stringBuilder = new StringBuilder(s);
//        int left = 0;
//        while (left < n && left < stringBuilder.length()) {
//            stringBuilder.append(s.charAt(left++));
//        }
//        return stringBuilder.substring(n);

        //解法三：
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, n - 1);
        reverse(sb, n, sb.length() - 1);
        return sb.reverse().toString();
    }

    public void reverse(StringBuilder str, int left, int right) {
        while (left < right) {
            char temp = str.charAt(left);
            str.setCharAt(left, str.charAt(right));
            str.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        System.out.println(reverseLeftWords("abcde", 2));
    }
}
