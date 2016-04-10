public class NumArray {
    private int[] nums;
    private int[] sums;
    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            this.nums[i] = nums[i];
        }
        this.sums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            sums[i] = this.nums[i];
            if(i - 1 >= 0){
                sums[i] += sums[i-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return this.sums[j] - this.sums[i] + this.nums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
