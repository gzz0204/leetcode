public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        long sum = 0;
        int min = nums[0];
        int max = nums[0];
        for(int num : nums){
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if(min != 0) return 0;
        sum = (min + max) * (max - min + 1) / 2 - sum;
        if(sum == 0){
            return max + 1;
        }else{
            return (int)sum;
        }
    }
}
