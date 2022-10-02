package com.ze.simple;

/**
 * @author ze
 * @creat 2022-09-24 19:45
 */
/*
双指针删除数组元素
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int fast, slow = 0;
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        for (fast = 0; fast < len; fast++) {
            //当不符合删除条件时才进入循环
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    //优化，但会改变数组顺序
    public int removeElement1(int[] nums, int val) {
        int left = 0, right =  nums.length;
        while(left < right){
            if(nums[left] == val){
                nums[left] = nums[right-1];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}
