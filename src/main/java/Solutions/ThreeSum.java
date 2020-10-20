package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * @author: zengleiyixiao
     * @description: leetcode 15
     * @date: 2020-09-09 11:04
     * @param nums int[]
     * @return List
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List res = new ArrayList();

        Arrays.sort(nums);
        int len = nums.length;
        if (nums[len-1] < 0){
            return res;
        }
        int i = 0;
        while (i < nums.length && nums[i] < 0){
            i++;
        }
        int left = 0;
        int right = i;
        for (int j = 1; j < len-1; j++){
            int sum = nums[left]+nums[j]+nums[right];
            if (nums[left]+nums[j]+nums[right] == 0){
                res.add(Arrays.asList(nums[left], nums[j], nums[right]));
            }
        }
        return res;
    }
}
