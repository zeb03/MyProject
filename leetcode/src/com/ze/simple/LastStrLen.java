package com.ze.simple;

import org.junit.Test;

/**
 * @author ze
 * @creat 2022-09-25 13:08
 */
public class LastStrLen {
    @Test
    public void test(){
        System.out.println(lengthOfLastWord("a "));
    }
    public int lengthOfLastWord(String s) {
        int start,end;
        if(s.length() == 0){
            return 0;
        }
        end = s.length()-1;
        while(s.charAt(end) == ' '){
            end--;
            if(end == 0){
                break;
            }
        }
        start = end - 1;
        while(start >= 0 &&s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }
}
