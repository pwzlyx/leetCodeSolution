package Solutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 56 区间合并
 */
public class MergeIntervals {
    public int[][] merge(final int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        ArrayList<int[]> merged = new ArrayList<>();
        for (int i=0; i < intervals.length; i++){
            int L = intervals[i][0]; int R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L,R});
            }else {
                merged.get(merged.size()-1)[1] = Math.max(R, merged.get(merged.size() -1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
