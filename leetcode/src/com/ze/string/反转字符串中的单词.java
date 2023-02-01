package com.ze.string;

import org.junit.Test;

import static com.ze.string.字符串函数库.split;
import static com.ze.string.字符串函数库.trim;

/**
 * author zebii
 * date 2023-01-13 23:19
 */
public class 反转字符串中的单词 {

    public String reverseWords3(String s) {
        char[] chars = s.toCharArray();
        chars = removeSpace(chars);
        reverse(chars, 0, chars.length - 1);
        reverseEachWords(chars);
        return new String(chars);
    }

    @Test
    public void test3() {
        System.out.println(reverseWords3(" you Hello World  "));
    }

    public void reverseEachWords(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast <= chars.length; fast++) {
            if (fast == chars.length || chars[fast] == ' ' ) {
                reverse(chars, slow, fast - 1);
                slow = fast + 1;
            }
        }
    }

    public void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    private char[] removeSpace(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!"".equals(strs[i])) {
                ans.append(strs[i]).append(" ");
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    public String reverseWords1(String s) {
        trim(s);
        String[] strs = split(s, " ");
        StringBuilder ans = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!"".equals(strs[i])) {
                ans.append(strs[i]).append(" ");
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }


    public String reverseWords2(String s) {
        int left = 0, right = s.length() - 1;

        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') continue;
            right = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            left = i + 1;
            for (int j = left; j <= right; j++) {
                ans.append(s.charAt(j));
            }
            ans.append(' ');
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }


    @Test
    public void test() {
        System.out.println(reverseWords1("a good   example"));
    }

}
