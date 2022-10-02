package com.ze.method;

import java.util.HashMap;

/**
 * @author ze
 * @creat 2022-09-25 13:18
 */
/*
problem 1 : 求数组中是否存在两个数的和等于指定数字(TwoSum)
method  1 : 使用哈希表，枚举数组中的每一个数 x,寻找数组中是否存在 target - x

problem 2 : 求字符串数组中最大的公共前缀(LongestCommonStr)
method  2 : 将strs[i][]存进哈希表中
 */
public class HashQuery {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMaps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMaps.containsKey(target - nums[i])) {
                return new int[]{hashMaps.get(target - nums[i]), i};
            }
            hashMaps.put(nums[i], i);
        }
        return null;
    }
}
