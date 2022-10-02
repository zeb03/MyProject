package com.ze.simple;

import org.junit.Test;

/**
 * @author ze
 * @creat 2022-09-25 14:14
 */
public class AddBinary {
    @Test
    public void test(){
        System.out.println(Solution.addBinary("11","1"));
    }
}
//思路：若最后一位数字为0，则直接进行加1；若最后一位数字不为0，则从后往前遍历，找到为0的元素，令其为1，后面元素为0，若全为1，则创建新数组
class Solution {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 || j >= 0) {
            if (i >= 0) carry += a.charAt(i--) - '0';
            if (j >= 0) carry += b.charAt(j--) - '0';
            builder.append(carry % 2);
            carry /=  2;
        }
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }
}
