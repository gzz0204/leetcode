public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() <= 1) return s;
        char[] str = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i = 0; i < str.length; i++){
            // i-1, i, i+1, i+2
            int expand = 0;
            while((i-expand) >= 0 && (i+1+expand) < str.length && str[i-expand] == str[i+1+expand]){
                if((expand + expand + 2) > (end - start + 1)){
                    start = i - expand;
                    end = i + 1 + expand;
                }
                expand ++;
            }

            // i-1, i, i+1
            expand = 1;
            while( i-expand >= 0 && i+expand < str.length && str[i-expand] == str[i+expand]){
                if(1+expand+expand > (end-start+1)){
                    end = i+expand;
                    start = i-expand;
                }
                expand ++;
            }
        }
        return new String(Arrays.copyOfRange(str, start,end+1));
    }
}
