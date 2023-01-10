package com.ze.array.binarySearch;

/**
 * author ze
 * date 2022-12-31 22:06
 */

public class x的平方根 {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if(x == 1){
            return 1;
        }
        int l, r, mid;
        l = 0;
        r = x / 2;
        while (l <= r) {
            mid = l + (r - l) / 2;
            long sum = (long) mid * mid;
            if (sum == x) {
                return mid;
            } else if (sum < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }
}
