package Solutions;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length){
            int lo = Math.max(A[i][0], B[j][0]);
            int ro = Math.min(A[i][1], B[j][1]);
            if (lo <= ro){
                ans.add(new int[]{lo, ro});
            }
            if (A[i][1] < B[i][1]){
                i++;
            }else{
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

}