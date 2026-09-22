/*
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0 */
public class MinimumSizeSubArraySum {
    public static int minSubArrayLen(int target, int[] nums){
        int left = 0;  // start of the current window
        int sum = 0;    // total of elements inside the window right now
        int short_subArray = Integer.MAX_VALUE;     // shortest valid window found so far; MAX means "none found yet"
        for(int right = 0; right < nums.length; right++){  // right walks through every index, expanding the window
            sum += nums[right];    // pull the new element into the window
            while(sum>=target){     // window is big enough -> try to shrink it as much as possible
                short_subArray = Math.min(short_subArray, right-left+1);  // record this window's length if it's the smallest so far
                sum -= nums[left];   // drop the leftmost element out of the window
                left++;   // move the start of the window one step right
            }
            // if sum < target here, window is too small, so the for loop just expands further (moves right)
        }
        return short_subArray == Integer.MAX_VALUE ? 0 : short_subArray; // no valid window ever found -> 0, else return the best length
    }
    public static void main(String[] args){
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
    
}
