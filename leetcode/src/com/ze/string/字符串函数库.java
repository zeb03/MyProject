package com.ze.string;

import java.util.ArrayList;

/**
 * author zebii
 * date 2023-01-14 22:15
 */
public class 字符串函数库 {

    public static String trim(String str) {
        int left = 0, right = str.length() - 1;
        while (left < str.length() && str.charAt(left) == ' ') left++;
        while (right >= 0 && str.charAt(right) == ' ') right--;
        return str.substring(left, right + 1);
    }

    public static String[] split(String str, String reg) {
        int off = 0, end = 0;
        ArrayList<String> list = new ArrayList<>();
        while (off < str.length()) {
            end = nextIndex(str, off, reg);
            list.add(str.substring(off, end));
            off = end + reg.length();
        }

        return list.toArray(new String[0]);
    }

    private static int nextIndex(String str, int off, String reg) {
        int index = str.length();
        for (int i = off; i < str.length(); i++) {
            int count = 0;
            while (count < reg.length() && i < str.length() && str.charAt(i) == reg.charAt(count)) {
                i++;
                count++;
            }
            if (count == reg.length()) {
                index = i - reg.length();
                break;
            }
        }
        return index;
    }
}
