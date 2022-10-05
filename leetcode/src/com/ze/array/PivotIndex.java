package com.ze.array;

import java.util.HashMap;

/**
 * @author ze
 * @Time 2022-10-04 23:32
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int rSum = 0;
        int lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
        }
        if(rSum == 0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if(lSum == rSum - nums[i]){
                return i;
            }
            lSum += nums[i];
            rSum -= nums[i];
        }
        return -1;
    }
}
