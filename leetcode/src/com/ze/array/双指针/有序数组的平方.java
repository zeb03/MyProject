package com.ze.array.双指针;

/**
 * author zebii
 * date 2023-02-01 21:06
 */
public class 有序数组的平方 {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，
     * 要求也按 非递减顺序 排序。
     *
     * @param nums
     * @return
     */
//    public int[] sortedSquares(int[] nums) {
//        int n = nums.length;
//        int left = 0;
//        int right = n - 1;
//        int[] ans = new int[n];
//        for (int i = right; i >= 0; i--) {
//            if (nums[left] * nums[left] < nums[right] * nums[right]) {
//                ans[i] = nums[right] * nums[right];
//                right--;
//            } else {
//                ans[i] = nums[left] * nums[left];
//                left++;
//            }
//        }
//        return ans;
//    }

    public int[] sortedSquares(int[] nums) {
        int border = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                border = i;
            }else{
                break;
            }
        }

        int[] result = new int[nums.length];
        int i = border, j = border + 1, index;
        for(index = 0;i>=0 || j < nums.length;index++){
            if(i<0){
                result[index]=nums[j]*nums[j];
                j++;
            } else if(j == nums.length){
                result[index] = nums[i]*nums[i];
                i--;
            } else if(nums[i]*nums[i] < nums[j]*nums[j]){
                result[index] = nums[i]*nums[i];
                i--;
            } else{
                result[index] = nums[j]*nums[j];
                j++;
            }
        }

        return result;
    }
}
