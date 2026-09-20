public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int nums[]){
        int count = 0, maxCount = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
                if(count > maxCount){
                    maxCount = count;
                }
            }
            else{
                count = 0;
            }
        }
        return maxCount;
    }
    public static void main(String[] args){
        int nums[] = {1,1,0,0,1,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
