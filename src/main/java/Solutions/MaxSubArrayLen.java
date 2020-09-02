package Solutions;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> numbers= new HashMap<Integer, Integer>();
        int[] sums = new int[nums.length+1];
        sums[0] = 0;
        numbers.put(0,0);
        for (int i = 1; i <= nums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
            if (!numbers.containsKey(sums[i])){
                numbers.put(sums[i], i);
            }
        }
        int max = 0;
        for (int i = sums.length-1; i > max; i--){
            if (numbers.containsKey(sums[i] - k)){
                max = Math.max(i - numbers.get(sums[i] - k), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = {1, -1, 5, -2, 3};
        MaxSubArrayLen maxSubArrayLen = new MaxSubArrayLen();
        int res = maxSubArrayLen.maxSubArrayLen(num, 3);
        System.out.println(res);
    }
}
