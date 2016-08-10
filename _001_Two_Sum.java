
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1,-1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int sub = target - nums[i];
            if(map.get(sub) != null){
                res[0] = i;
                res[1] = map.get(sub);
                return res;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
    public int[] twoSum2(int[] nums, int target) {
        int index1 = 0;
        int index2 = 0;
        int[] ret = new int[2];
        for(; index1 < nums.length - 1; index1++){
            for(index2 = index1 + 1; index2 < nums.length; index2++){
                if(nums[index1] + nums[index2] == target){
                    ret[0] = index1;
                    ret[1] = index2;
                    return ret;
                }
            }
        }
        return new int[0];
    }
}

