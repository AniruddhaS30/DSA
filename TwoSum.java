import java.util.*;
import java.util.HashMap;
public class TwoSum {
    public static int[] twoSum(int nums[], int target){
        Map<Integer, Integer> newMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(newMap.containsKey(target-nums[i])){
                return new int[] {newMap.get(target-nums[i]), i};

            }
            newMap.put(nums[i],i);
        }
        return new int[]{};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
    }
}
