package com.ze.array.滑动窗口;

/**
 * author ze
 * date 2023-01-02 21:20
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            int subLength = right - left + 1;
            while (sum >= target) {
                result = Math.min(result, subLength);
                sum -= nums[left++];
                subLength--;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
