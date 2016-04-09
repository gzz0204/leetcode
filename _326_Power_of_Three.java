public class Solution {
    public boolean isPowerOfThree(int n) {
        while( n > 1 ){
            if( n % 3 != 0){
                return false;
            }else{
                n /= 3;
            }
        }
        return n == 1;
    }
}
