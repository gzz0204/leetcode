import java.util.Arrays;
import java.util.LinkedList;
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList();
        for(LinkedList<Integer> l:kSum(nums, target, 4)){
            ret.add(new ArrayList<Integer>(l));
        }
        return ret;
    }

    public LinkedList<LinkedList<Integer>> kSum(int[] nums, int target, int k){
        if(nums.length < k){
            return new LinkedList();
        }

        Arrays.sort(nums);

        LinkedList<LinkedList<Integer>> ret = new LinkedList<LinkedList<Integer>>();

        Integer prev = null;
        for(int i = 0; i <= nums.length - k; i++){
            if(prev != null && prev.equals(nums[i])){
                continue;
            }
            prev = nums[i];
            LinkedList<LinkedList<Integer>> result = kSum(Arrays.copyOfRange(nums, i+1, nums.length), target-nums[i],k-1);
            for(LinkedList<Integer> l : result){
                l.addFirst(nums[i]);
                ret.add(l);
            }
        }
        return ret;
    }
}
