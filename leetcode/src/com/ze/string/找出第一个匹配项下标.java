package com.ze.string;

import org.junit.Test;

/**
 * author zebii
 * date 2023-01-18 21:18
 */
public class 找出第一个匹配项下标 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            int j = i;
            while (j < haystack.length() && haystack.charAt(j) == needle.charAt(j - i)) {
                j++;
                if (j - i == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Test
    public void test1() {
        System.out.println(strStr("abcd", "bc"));

    }

}
