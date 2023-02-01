package com.ze.array;

/**
 * @author ze
 * @creat 2022-09-25 13:25
 */

public class DoublePoint {

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
