public class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        if(s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){
            if(str[i] == '(' || str[i] == '[' || str[i] == '{'){
                stack.push(str[i]);
            }else if(str[i] == ')' || str[i] == ']' || str[i] == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((str[i] == ')' && top != '(')
                || (str[i] == ']' && top != '[')
                || (str[i] == '}' && top != '{')){
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
