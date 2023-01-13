package com.ze.hash;

import java.util.*;

/**
 * author zebii
 * date 2023-01-11 23:37
 */
public class 三数之和 {
    //错误案例，因为包含了重复元组的情况，如果要继续写下去，可能要判断元组是否重复，这会耗费大量时间
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> list = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (list.contains(-num1 - num2)) {
                    List<Integer> temp = Arrays.asList(num1, num2, -num1 - num2);
                    ans.add(temp);
                }
            }
            list.add(num1);
        }
        return ans;
    }

    //解法二：双指针
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[left - 1]) right--;

                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
