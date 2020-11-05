package Solutions;

import java.util.ArrayList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
       if (intervals.length == 0 && newInterval.length==0){
           return null;
       }
       if (intervals.length==0){
           return new int[][]{newInterval};
       }
       int[][] newIntervals = new int[intervals.length+1][];
       boolean flag = false;
       for (int i =0,j=0; i<intervals.length;i++,j++){
           if (intervals[i][0] >= newInterval[0] && !flag){
               newIntervals[j] = newInterval;
               newIntervals[++j] = intervals[i];
               flag = true;
           }else {
               newIntervals[j] = intervals[i];
           }
       }
       if (!flag){
           newIntervals[newIntervals.length-1] = newInterval;
       }
        ArrayList<int[]> merged = new ArrayList<>();
        for (int i=0; i < newIntervals.length; i++){
            int L = newIntervals[i][0]; int R = newIntervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L,R});
            }else {
                merged.get(merged.size()-1)[1] = Math.max(R, merged.get(merged.size() -1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = new int[5][];
        intervals[0] = new int[]{1,2};
        intervals[1] = new int[]{3,5};
        intervals[2] = new int[]{6,7};
        intervals[3] = new int[]{8,10};
        intervals[4] = new int[]{12,16};
        insertInterval.insert(intervals, new int[]{4,8});
    }
}
