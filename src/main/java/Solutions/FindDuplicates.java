package Solutions;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442 数组中重复的数据
 */
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        if (nums.length == 0){
            return new ArrayList<>();
        }
        for(int i=0; i < nums.length;i++){
            while (nums[i] != nums[nums[i]-1]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i=0; i < nums.length;i++){
            if (i != nums[i]-1){
                resList.add(nums[i]);
            }
        }
        return resList;
    }

    public List<Integer> findDuplicates2(int[] nums){
        List<Integer> resList = new ArrayList<>();
        for (int i=0; i < nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0){
                resList.add(Math.abs(index+1));
            }
            nums[index] = -nums[index];
        }
        return resList;
    }

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        int[] input = new int[]{4,3,2,7,8,2,3,1};
        findDuplicates.findDuplicates(input);
    }
}
