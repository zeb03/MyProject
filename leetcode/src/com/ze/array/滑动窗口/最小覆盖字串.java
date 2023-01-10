package com.ze.array.滑动窗口;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * author ze
 * date 2023-01-03 20:43
 */
public class 最小覆盖字串 {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        int start = -1, end = -1, subLen, minLen = Integer.MAX_VALUE;
        while (r < s.length()) {
            if (need.containsKey(s.charAt(r))) {
                window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            }
            subLen = r - l + 1;
            while (check() && l <= r) {
                subLen--;
                window.put(s.charAt(l), window.getOrDefault(s.charAt(l), 0) - 1);
                ++l;
                if (subLen < minLen) {
                    minLen = subLen;
                    end = r + 1;
                    start = r - minLen;
                }
            }
            r++;
        }
        return start == -1 ? "" : s.substring(start, end);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (window.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
