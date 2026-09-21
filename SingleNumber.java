/* Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1 */
import java.util.*;
public class SingleNumber {
    public static int singleNumber(int[] nums){
        // HashMap: stores key-value pairs; here key = number, value = how many times it appeared
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int num: nums){
            // getOrDefault(num,0): returns num's current count, or 0 if num isn't in the map yet
            // put(): stores the key with its updated count (overwrites the old count if the key exists)
            counts.put(num, counts.getOrDefault(num,0)+1);
        }
        // Map.Entry: one key-value pair from the map; entry is the current pair in the loop
        for(Map.Entry<Integer,Integer> entry : counts.entrySet()){
            // getValue(): returns the count stored in this entry
            if(entry.getValue()==1){
                // getKey(): returns the number stored in this entry
                return entry.getKey();
            }
        }
        return -1;

    }
    public static void main(String[] args){
        int nums[] = {1,2,3,2,1,3,4};
        System.out.println(singleNumber(nums));
    }
}