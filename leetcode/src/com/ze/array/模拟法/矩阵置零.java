package com.ze.array.模拟法;

import org.junit.Test;

import java.util.Arrays;

/**
 * author ze
 * date 2023-01-04 20:48
 */
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Boolean[] rows = new Boolean[n];
        Boolean[] columns = new Boolean[m];
        for (int i = 0; i < n; i++) {
            rows[i] = false;
        }
        for (int i = 0; i < m; i++) {
            columns[i] = false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }

        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void test() {
        setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }
}

