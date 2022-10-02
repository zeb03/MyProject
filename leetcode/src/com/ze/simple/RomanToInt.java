package com.ze.simple;

import org.junit.Test;

/**
 * @author ze
 * @creat 2022-09-21 21:01
 * @Describe 将罗马数字转换为int型数字
 */
public class RomanToInt {
    @Test
    public void test1() {
        System.out.println(romanToInt("XXVII"));
    }

    public int romanToInt(String s) {
        int prenum = charToInt(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int num = charToInt(s.charAt(i));
            if (num > prenum) {
                sum -= prenum;
            } else {
                sum += prenum;
            }
            prenum = num;
        }
        sum += prenum;
        return sum;
    }

    public int charToInt(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
