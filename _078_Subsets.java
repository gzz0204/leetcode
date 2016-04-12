public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // []
        // [], | [nums[0]] <- add nums[0]
        // [], [nums[0]], | [nums[1]], [nums[0], [nums1]] <- add nums[1]
        // [], [nums[0]], [nums[1]], [nums[0], [nums1]] | ...... <- add nums[2]
        // the size of the result is doubled in each step.
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>()); // add []
        for(int num : nums){
            int prevSize = res.size();
            for(int i = 0; i < prevSize; i++){
                List<Integer> newEle = new ArrayList<>(res.get(i)); // create a new list
                newEle.add(num);
                res.add(newEle);
            }
        }
        return res;
    }


    public List<List<Integer>> subsets2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int len = set.size();
        int[] elements = new int[len];
        int index = 0;
        for(int element : set){
            elements[index] = element;
            index ++;
        }
        Arrays.sort(elements);
        LinkedList<List<Integer>> res = new LinkedList<>();
        subsetHelper(res, elements, new LinkedList<Integer>(), -1);
        return res;
    }

    private void subsetHelper(LinkedList<List<Integer>> res, int[] nums, LinkedList<Integer> prevs, int from){
        res.addLast((LinkedList<Integer>)prevs.clone());
        for(int i = from + 1; i < nums.length; i++){
            prevs.addLast(nums[i]);
            subsetHelper(res, nums, prevs, i);
            prevs.removeLast();
        }
    }
}
