package com.ze.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ze
 * @Time 2022-10-05 0:00
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        int []temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(temp[1] >= intervals[i][0]){
                temp[1] = Math.max(temp[1],intervals[i][1]);
            }else {
                list.add(temp);
                temp = intervals[i];
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][2]);
    }

}
