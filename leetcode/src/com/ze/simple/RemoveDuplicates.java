package com.ze.simple;

import org.junit.Test;

/**
 * @author ze
 * @creat 2022-09-23 13:16
 */
/*
给你一个升序排列数组nums,删除重复出现的元素,使每个元素只出现一次,返回删除后数组的新长度,元素的相对顺序应该保持一致.

 */
public class RemoveDuplicates {
    @Test
    public void test(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
        }
    }
    /*
    思路：创建两个指针fast,slow
         fast遍历数组
         slow指向需要插入的位置
         当fast指向的元素与slow不相等，便插入slow的位置
     */
    public int removeDuplicates(int[] nums) {
        int fast = 1, low = 1;
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        for (; fast < len; fast++) {
            if (nums[fast] > nums[fast - 1]) {
                nums[low] = nums[fast];
                ++low;
            }
        }
        return low;
    }
}
