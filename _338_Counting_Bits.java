public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++){
            int curNum = i;
            int ones = 0;
            while(curNum != 0){
                if((curNum & 1) == 1){
                    ones ++;
                }
                curNum = curNum >>> 1;
            }
            res[i] = ones;
        }
        return res;
    }
}
