package com.ze.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ze
 * @creat 2022-09-20 20:11
 * @Describe 枚举数组中的每一个数 x,寻找数组中是否存在 target - x
 */
public class TwoSum {

    //使用哈希表
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

    @Test
    public void test1(){
        int[] nums = new int[]{1,3,5,9,2,-2};
        int target = 3;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
