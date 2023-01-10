package com.ze.array;

/**
 * @author ze
 * @creat 2022-09-25 13:25
 */

public class DoublePoint {

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

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i != m || j != n) {
            if (i == m) {
                while (j != n) {
                    sort[index++] = nums2[j++];
                }
                break;
            } else if (j == n) {
                while (i != m) {
                    sort[index++] = nums1[i++];
                }
            } else if (nums1[i] > nums2[j]) {
                sort[index++] = nums2[j++];
            } else {
                sort[index++] = nums1[i++];
            }
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = sort[k];
        }
    }
}
