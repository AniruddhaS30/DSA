/*
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */
import java.util.HashSet;
import java.util.Arrays;
public class IntersectionOfTwoArrays {
    public static int[] intersection(int nums1[], int nums2[]){
        HashSet <Integer> set = new HashSet<>();
        HashSet <Integer> results = new HashSet<>();

        for(int num: nums1){
            set.add(num);
        }
        for(int num: nums2){
         if(set.contains(num)){
            results.add(num);
         }   
        }
        int [] answer = new int[results.size()];
        int i=0;
        for(int num: results){
            answer[i] = num;
            i++;

        }
        return answer;

    }
    public static void main(String [] args){
        int nums1[] = {1,2,3,2,1};
        int nums2[] = {1,3};
        int answer[] = intersection(nums1,nums2);
        System.out.println(Arrays.toString(answer));

         /*Arrays.toString() is a utility method from Java's java.util.Arrays class. 
        It's mainly used to convert an array into a readable String so you can
         actually see its contents when you print it. */

         /* The approach uses two HashSets to solve it efficiently: 
         first, all values from nums1 are added to a HashSet for fast lookups, 
         then nums2 is scanned once, adding any matching value into a second HashSet called results
          which automatically handles duplicate removal. 
          Finally, results is converted into an int[] of the correct size and returned. 
          This runs in O(n + m) time, much faster than the O(n × m) brute-force approach. */
    }
}
