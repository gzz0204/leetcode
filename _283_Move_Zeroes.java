public class Solution {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        int pivot = 0;
        while(pivot < nums.length){
            if(nums[pivot] != 0){
                if(pivot != nonZero){
                    nums[nonZero] = nums[pivot];
                    nums[pivot] = 0;
                }
                nonZero ++;
            }
            pivot ++;
        }
    }
}
