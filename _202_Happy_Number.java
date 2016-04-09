public class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        while(map.get(n) == null){
            map.put(n, true);
            int res = 0;
            while(n != 0){
                res += (n % 10)*(n % 10);
                n /= 10;
            }
            n = res;
        }
        return n == 1;
    }
}
