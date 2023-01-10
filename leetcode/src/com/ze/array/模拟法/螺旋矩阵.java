package com.ze.array.模拟法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author ze
 * date 2023-01-03 23:19
 */
public class 螺旋矩阵 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int startX = 0, startY = 0;
        int loop = 0;
        int count = 1;
        int i, j;
        while (loop++ < n / 2) {
            for (j = startY; j < n - loop; j++) {
                ans[startX][j] = count++;
            }
            for (i = startX; i < n - loop; i++) {
                ans[i][j] = count++;
            }
            for (; j >= loop; j--) {
                ans[i][j] = count++;
            }
            for (; i >= loop; i--) {
                ans[i][j] = count++;
            }
            startY++;
            startX++;
        }
        if (n % 2 == 1) {
            ans[startX][startY] = count;
        }
        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i, j;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            for (i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (j = right - 1; j > left; j--) {
                    list.add(matrix[bottom][j]);
                }
                for (i = bottom; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    @Test
    public void test1() {
        for (int[] ints : generateMatrix(3)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
}
