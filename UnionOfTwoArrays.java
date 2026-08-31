/* 
Example 1
Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
Output: [1, 2, 3, 4, 5, 7]
Explanation:
The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2 */
import java.util.HashSet;
import java.util.Arrays;
public class UnionOfTwoArrays {
    public static int[] unionArray(int[] nums1, int[] nums2) {
        HashSet <Integer> set = new HashSet <>();
        HashSet <Integer> result = new HashSet <>();
        for(int num: nums1){
            set.add(num);
        }
        for(int num: nums2){
            set.add(num);
        }
        int [] answer = new int[set.size()];
        int i = 0;
        for(int num: set){
        answer[i] = num;
        i++;
        }
        return answer;
    }
    public static void main(String[] args){
        int nums1[] = {1,2,3,4,5};
        int nums2[] = {7,8,9};
        int answer[] = unionArray(nums1, nums2);
        System.out.print(Arrays.toString(answer));
    }

}
/* 
The code first creates a `HashSet` to store unique elements. 
It adds all the elements from `nums1` and then all the elements from `nums2` into the same set, 
so duplicates are automatically removed. After that, an `answer` array is created with the same size as the 
set. The code then loops through the set and copies each element into the `answer` array
 using the index `i`, and finally returns the array. For printing the array, `Arrays.toString(answer)` 
 is used so that the actual elements are displayed.
 */
