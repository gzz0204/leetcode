public class Solution {
    public int maxProduct(String[] words) {
        // bit manipulation
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });

        int[] wordsBits = new int[words.length];
        // default value in wordsBits is zero
        for(int i = 0; i < words.length;i++){
            for(char c : words[i].toCharArray()){
                if( c > 'z' || c < 'a'){
                    return -1;
                }else{
                    wordsBits[i] = wordsBits[i] | 1 << c - 'a';
                }
            }
        }
        int res = 0;
        for(int i = 0; i < words.length - 1; i++){
            if(words[i].length() * words[i].length() <= res){
                break;
            }
            for(int j = i+1; j < words.length; j++){
                if(words[i].length() * words[j].length() < res){
                    break;
                }
                if((wordsBits[i] & wordsBits[j]) == 0){
                    // do not have common character
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
