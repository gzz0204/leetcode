public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        for(int i = 0; i < notPrime.length; i++){
            notPrime[i] = false;
        }
        for(int i = 2; i <= (n-1) / 2; i++){
            int index = i + i;
            while(index < n){
                notPrime[index] = true;
                index += i;
            }
        }
        int res = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i] == false){
                res ++;
            }
        }
        return res;
    }


    public int countPrimesBruteForce(int n) {
        int res = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i)){
                res ++;
            }
        }
        return res;
    }
    private boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        if(num <= 3){
            return true;
        }
        if( num % 2 == 0 || num % 3 == 0){
            return true;
        }
        int end = num / 2;
        for(int i = 4; i <= end; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
