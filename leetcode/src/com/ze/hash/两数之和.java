package com.ze.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * author zebii
 * date 2023-01-11 21:54
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        //解法一：暴力法
        //解法二：map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index = map.get(target - nums[i]);
                return new int[]{index, i};
            }
        }
        return null;
    }
    @Test
    public void test(){
        twoSum(new int[]{3,2,4},6);
    }
}
