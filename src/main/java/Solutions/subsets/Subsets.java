package Solutions.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.educative.io/courses/grokking-the-coding-interview/gx2OqlvEnWG
 * 问题描述:Given a set with distinct elements, find all of its distinct subsets.
 */

class Subsets{
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int i=0;i<nums.length;i++){
            int n = subsets.size();
            for (int j=0;j<n;j++){
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
