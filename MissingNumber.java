/*
Example:
Input: nums = [3,0,1]
Output: 2
Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
2 is the missing number in the range since it does not appear in nums. */
import java.util.*;
public class MissingNumber {
    public static int missingNumber(int nums[]){
        HashSet <Integer> set = new HashSet<>();
        int n  = nums.length;
        for(int num: nums){
            set.add(num);
        }
        for(int i=0;i<=n;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int nums[] = {1,2,3,4,5,6};
        // main() is static, but missingNumber() is NOT static
        // -> can't call it directly, need an object first
        //int answer = missingNumber(nums); -> this is if both main and the func is static 
        //if only the main is static and the func is not static then the obj 
        MissingNumber obj = new MissingNumber();  // create object from the class blueprint
        int answer = obj.missingNumber(nums);      // call method ON that object
        System.out.println(answer);

    }
}
