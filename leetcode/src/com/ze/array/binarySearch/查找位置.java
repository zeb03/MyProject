package com.ze.array.binarySearch;

/**
 * author ze
 * date 2022-12-31 22:07
 */
public class 查找位置 {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
     */
    //解法一：找最左位置和最右位置
    public int[] searchRange1(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right >= 0 && right < nums.length && nums[right] == target) {
            return right;
        }
        if (left >= 0 && left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= 0 && left < nums.length && nums[left] == target) {
            return left;
        }
        if (right >= 0 && right < nums.length && nums[right] == target) {
            return right;
        }
        return -1;
    }

    //解法二：找到元素后，向左向右扩大范围
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int indexL, indexR;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                indexL = indexR = mid;
                while (indexL > 0 && nums[mid] == nums[indexL - 1]) {
                    indexL--;
                }
                while (indexR < nums.length - 1 && nums[mid] == nums[indexR + 1]) {
                    indexR++;
                }
                return new int[]{indexL, indexR};
            }
        }
        return new int[]{-1, -1};
    }
}
