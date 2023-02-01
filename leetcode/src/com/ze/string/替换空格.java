package com.ze.string;

import org.junit.Test;

/**
 * author zebii
 * date 2023-01-13 22:17
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        char[] arr = new char[s.length() + count * 2];
        int slow = 0;
        int fast = 0;
        while (fast < s.length()) {
            if (s.charAt(fast) != ' ') {
                arr[slow++] = s.charAt(fast);
            } else {
                arr[slow++] = '%';
                arr[slow++] = '2';
                arr[slow++] = '0';
            }
            fast++;
        }
        return new String(arr,0,slow);
    }

    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }
    @Test
    public void test(){
        replaceSpace1("abc def");
    }
}
