package com.ze.method;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ze
 * @Time 2022-10-06 23:15
 */
public class ArraysToCollection {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        List<int[]> list = Arrays.asList(arr);
        list.toArray(new int[list.size()][5]);
    }
}
