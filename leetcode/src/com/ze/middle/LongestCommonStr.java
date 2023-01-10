package com.ze.middle;


import org.junit.Test;

/**
 * @author ze
 * @creat 2022-09-21 21:29
 * @Descirbe 编写一个函数来查找字符串数组中的最长公共前缀,如果不存在公共前缀,返回空字符串 "".
 */
public class LongestCommonStr {
    @Test
    public void test1() {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            prefix = newPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String newPrefix(String str1, String str2) {
        int index = 0;
        int minLen = Math.min(str1.length(), str2.length());
        while (index < minLen && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
