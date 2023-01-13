package com.ze.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * author ze
 * date 2023-01-11 21:15
 */
public class 快乐数 {
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = next(n);
        }
        return n == 1;
    }

    private int next(int n) {
        int total = 0;
        while (n != 0) {
            int temp = n % 10;
            total += temp * temp;
            n /= 10;
        }
        return total;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = next(n);
        while (slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        return fast == 1;
    }
}
