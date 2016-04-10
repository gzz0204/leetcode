public class Solution {
    public void rotate(int[] nums, int k) {
        if( k > nums.length){
            k = k % nums.length;
        }
        int[] numsCopy = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsCopy[i] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            int position = i - k;
            if(position < 0){
                position = nums.length + position;
            }
            nums[i] = numsCopy[position];
        }
    }
}
