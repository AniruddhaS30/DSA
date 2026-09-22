/*
Example 1:
Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:
Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:
Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17] */
import java.util.Arrays;
public class RunningSumOf1DArray {
    public static int[] runningSum(int[] nums){
        int runningTotal = 0;
        for(int i=0;i<nums.length;i++){
            runningTotal += nums[i];
            nums[i] = runningTotal;
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        runningSum(nums);
        System.out.println(Arrays.toString(nums));
    }
}
