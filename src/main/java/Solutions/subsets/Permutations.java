package Solutions.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.educative.io/courses/grokking-the-coding-interview/B8R83jyN3KY
 *
 * Given a set of distinct numbers, find all of its permutations.
 */
public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.offer(new ArrayList<>());
        for (int i=0;i < nums.length;i++){
            int n = permutations.size();
            for (int j=0;j < n;j++){
                List<Integer> oldPermutation = permutations.poll();
                for (int k=0; k <= oldPermutation.size();k++){
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(k, nums[i]);
                    if (newPermutation.size() == nums.length){
                        result.add(newPermutation);
                    }else{
                        permutations.offer(newPermutation);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
