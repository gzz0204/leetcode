public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.get(nums[i]) == null){
                // key not exists
                hm.put(nums[i], 1);
            }else{
                // key exists
                hm.put(nums[i], hm.get(nums[i]) + 1);
                if(hm.get(nums[i]) > (nums.length/2)){
                    return nums[i];
                }
            }
        }
        return nums[0];
    }
}
