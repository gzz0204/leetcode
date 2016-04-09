public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);

        // boolean[] states = new boolean[n];
        // for(int i = 0; i < states.length; i++){
        //     // are initially off
        //     states[i] = false;
        // }
        // for(int i = 1; i <= n; i++){
        //     int index = i;
        //     while( index <= states.length){
        //         states[index-1] = !states[index-1];
        //         index += i;
        //     }
        // }
        // int res = 0;
        // for(boolean state : states){
        //     if(state == true){
        //         res ++;
        //     }
        // }
        // return res;
    }
}
