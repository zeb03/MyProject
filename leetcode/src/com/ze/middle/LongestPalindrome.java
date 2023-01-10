package com.ze.middle;

/**
 * @author ze
 * @date 2022-10-15 23:12
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int start = 0;
        int index = 0;
        int maxLen = 1;
        int len = 1;
        boolean dp = false;
        boolean[] flag = new boolean[s.length()];
        if (s.length() < 2){
            return s;
        }else if (s.length() == 2){
            if (s.charAt(0) == s.charAt(1)){
                return s;
            }else {
                return "";
            }
        }
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            index = 1;
            dp = false;
            while (i - index >= 0 || i + index <= array.length - 1){
                if (i - index >= 0 && array[i - index] == array[i]){

                }
                /*if (array[i - index] == array[i + index]){
                    index++;
                    dp = true;
                }else {
                    break;
                }*/
            }
            if(dp){
                len = 1 + (index - 1) * 2;
            }
            if (len > maxLen){
                maxLen = len;
                start = i - index;
            }
        }
        return s.substring(start,start + maxLen);
    }
}
