package com.ze.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * author zebii
 * date 2023-01-11 22:38
 */
public class 四数相加 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int sum = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                if (map.containsKey(-i - j)) {
                    sum += map.get(-i - j);
                }
            }
        }
        return sum;
    }
}
