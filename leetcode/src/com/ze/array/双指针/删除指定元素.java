package com.ze.array.双指针;

/**
 * author zebii
 * date 2023-02-01 21:06
 */
public class 删除指定元素 {
    /*
    problem : 指定一个整数，删除给定的整数数组中存在的目标值
    method : 使用双指针,有两种方法，首尾指针效率更高，但会改变数组顺序
     */
    public int removeElement1(int[] nums, int val) {
        int fast, slow = 0;
        int len = nums.length;
        if (len == 0) {
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
    public int removeElement2(int[] nums, int val) {
        int left, right;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            while (right >= left && nums[right] == val) {
                right--;
            }
            while (right >= left && nums[left] != val) {
                left++;
            }
            if (left <= right) {
                nums[left++] = nums[right--];
            }
        }
        return left;
    }
}
