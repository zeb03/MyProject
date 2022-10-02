package com.ze.simple;

import org.junit.Test;

/**
 * @author ze
 * @creat 2022-09-22 20:06
 * @Describe 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class ValidStr {

    @Test
    public void test(){
        String str = "{([(])}";
        System.out.println(isValid(str));
    }
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isLeft(s.charAt(i))) {
                stack[top++] = s.charAt(i);
            } else {
                if (top > 0 && isVailRight(stack[top - 1], s.charAt(i))) {
                    top--;
                } else {
                    return false;
                }
            }
        }
        if(top > 0){
            return false;
        }
        return true;
    }

    public boolean isLeft(char ch) {
        if (ch == '(' || ch == '[' || ch == '{') {
            return true;
        }
        return false;
    }

    public boolean isVailRight(char preCh, char ch) {
        boolean isVail = false;
        switch (preCh) {
            case '(':
                if (ch == ')') {
                    isVail = true;
                }
                break;
            case '[':
                if (ch == ']') {
                    isVail = true;
                }
                break;
            case '{':
                if (ch == '}') {
                    isVail = true;
                }
        }
        return isVail;
    }
}
