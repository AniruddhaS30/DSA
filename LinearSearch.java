/*Example 1
Input: nums = [2, 3, 4, 5, 3], target = 3
Output: 1
Explanation:
The first occurence of 3 in nums is at index 1
Example 2
Input: nums = [2, -4, 4, 0, 10], target = 6
Output: -1
Explanation:
The value 6 does not occur in the array, hence output is -1 */
public class LinearSearch {
    public static int linearSearch(int nums[],int target ){
        int n = nums.length;
        for (int i=0;i<n;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int nums[]={1,2,3,4,5,6,7};
        int target = 4;
        System.out.print(linearSearch(nums,target));

    }
}
