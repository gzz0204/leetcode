public class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.get(num) == null){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        int[] res = {0,0};
        int count = 0;
        for(int num : map.keySet()){
            if(map.get(num) == 1){
                res[count] = num;
                count ++;
                if(count >= 2){
                    return res;
                }
            }
        }
        return null;
    }
}
