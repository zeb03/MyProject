package com.ze.string;

/**
 * author zebii
 * date 2023-01-13 21:23
 */
public class 反转字符串II {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count++;
            if (count == k * 2) {
                swap(chars, i - count + 1, i - k);
                count = 0;
            }
        }
        if (count < k) {
            swap(chars, chars.length - count, chars.length - 1);
        } else {
            swap(chars, chars.length - count, chars.length - count + k - 1);
        }
        return String.valueOf(chars);
    }

    public String reverseStr1(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i;
            int right = Math.min(arr.length - 1, i + k - 1);
            swap(arr, left, right);
        }
        return new String(arr);
    }

    private void swap(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
