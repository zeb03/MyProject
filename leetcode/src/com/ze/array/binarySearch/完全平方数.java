package com.ze.array.binarySearch;

/**
 * author ze
 * date 2022-12-31 23:15
 */
public class 完全平方数 {
    /*
    给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。

     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long left = 1, right = num / 2;
        long mid = left;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
