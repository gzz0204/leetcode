public class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while(fast != nums.length){
            if(nums[fast] != val){
                if(slow != fast){
                    nums[slow] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
