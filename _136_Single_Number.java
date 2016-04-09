public class Solution {
    public int singleNumber(int[] nums) {
        // xor
        return singleNumberHashMap(nums);
    }

    public int singleNumberHashMap(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            if(map.get(num) == null){
                map.put(num, false);
            }else{
                map.put(num, true);
            }
        }
        for(Integer num : map.keySet()){
            if(map.get(num) == false){
                return num;
            }
        }
        return -1;
    }

    public int singleNumberBitManipulation(int[] nums) {
        // xor
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}
