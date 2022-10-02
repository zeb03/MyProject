package com.ze.simple;

import org.junit.Test;

/**
 * @author ze
 * @creat 2022-09-28 22:16
 */
public class MySqrt {

    @Test
    public void test() {
        System.out.println(mySqrt(2147395600));
    }

    /*
    思路：若x的平方根取整为a,则(a+1)*(a+1)>x,利用此特点,进行查找
    1.暴力查找，从1到x/2，效率低
    2.二分查找，从1到x/2，效率高

    分析：mid = (l + r) / 2 ---> mid = l + (r - l) / 2;
         避免数据溢出
         二分查找时，若开根号不是整数，则指针一定会指向下一个元素，因此需返回l-1
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
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
