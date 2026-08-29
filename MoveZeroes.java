/*Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]*/
import java.util.Arrays;
public class MoveZeroes {
    public static void moveZeroes(int [] nums){
        int n = nums.length;
        int j = -1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        for(int i=j+1;i<n;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
    public static void main(String [] args){
        int nums[] = {0,1,2,0,3};
        MoveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        /*Arrays.toString() is a utility method from Java's java.util.Arrays class. 
        It's mainly used to convert an array into a readable String so you can
         actually see its contents when you print it. */
    }
    
}
