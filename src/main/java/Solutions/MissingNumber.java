package Solutions;

/**
 * 268 丢失的数字
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length;i++){
            n ^= i^nums[i];
        }
        return n;
    }

    public int missingNumber2(int[] nums){
        int ins = 0;
        for (int i =0;i<nums.length;i++){
           ins = ins +i+1;
           ins -= nums[i];
        }
        return ins;
    }
}
