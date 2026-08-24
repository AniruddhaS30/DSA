public class RotateArray {
    public static void rotate(int [] nums, int k){
        int n = nums.length;
        k=k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0,k-1);
        reverse(nums, k, n-1);

    }
    public static void reverse(int [] nums, int start, int end){//two pointer approach
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] =temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int nums[] = {1,2,3,4,5,6,7};
        int k=3;
        rotate(nums, k);
        
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
/* In this specific code to rotate the array by k places(right rotate) in the first rotate func we rotate the nums
, firstly we reverse the entire array, then reverse the first k elements, and finally reverse the remaining elements 
the reverse() function is using the two-pointer approach to reverse a specific portion of the array in-place.*/