public class Solution {
    public String convertToTitle(int n) {
        LinkedList<Character> list = new LinkedList<>();
        while( n != 0){
            if( n % 26 == 0){
                list.addFirst('Z');
            }else{
                list.addFirst((char)('A' + (n % 26) - 1));
            }

            n = (n - 1) / 26;
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : list){
            sb.append(c);
        }
        return sb.toString();
    }
}
