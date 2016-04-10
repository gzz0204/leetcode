public class Solution {
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;

        boolean negtive = false;
        int index = 0;
        char[] s = str.toCharArray();
        if(s[index] < '0' || s[index] > '9'){
            if(s[index] == '-'){
                negtive = true;
            }else if(s[index] == '+'){
                negtive = false;
            }else{
                return 0;
            }
            index ++;
        }
        long res = 0;
        while(index < s.length && s[index] <= '9' && s[index] >= '0'){
            res *= 10;
            res += s[index] - '0';
            if( (res -1 )> Integer.MAX_VALUE){
                break;
            }
            index ++;
        }
        if(negtive){
            res = -res;
            if(res < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            return (int)res;
        }else{
            if(res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            return (int)res;
        }
    }
}
