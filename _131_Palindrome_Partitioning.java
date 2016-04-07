public class Solution {
    public List<List<String>> partition(String s) {
        LinkedList<List<String>> res = new LinkedList<>();
        HashMap<Integer, LinkedList<Integer>> hm = new HashMap<>();
        // search all palindromes
        char[] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++){
            for(int j = 0; i - j >= 0 && i + j < sArray.length; j++){
                if(sArray[i-j] == sArray[i+j]){
                    int start = i - j;
                    int end = i + j + 1;
                    if(hm.get(start) == null){
                        // key not exist
                        hm.put(start, new LinkedList<Integer>());
                    }
                    hm.get(start).addLast(end);
                }else{
					break;
				}
            }
            for(int j = 0; i - j - 1 >= 0 && i + j < sArray.length; j++){
                if(sArray[i-j-1] == sArray[i+j]){
                    int start = i - j - 1;
                    int end = i + j + 1;
                    if(hm.get(start) == null){
                        // key not exist
                        hm.put(start, new LinkedList<Integer>());
                    }
                    hm.get(start).addLast(end);
                }else{
					break;
				}
            }
        }
        LinkedList<LinkedList<Integer>> queue = new LinkedList<>();
        for(Integer i : hm.get(0)){
            LinkedList<Integer> l = new LinkedList<>();
            l.addFirst(i);
            queue.addLast(l);
        }
        while(!queue.isEmpty()){
            Integer lastPos = queue.getFirst().getLast();
            if(lastPos == s.length()){
                // find a solution
                LinkedList<String> sol = new LinkedList<>();
                int id1 = 0;
                for(int id2 : queue.getFirst()){
                    sol.addLast(String.valueOf(Arrays.copyOfRange(sArray, id1, id2)));
                    id1 = id2;
                }
                res.addLast(sol);
                queue.removeFirst();
            }else{
                // not a solution
                LinkedList<Integer> nextPositions = hm.get(lastPos);
                if(nextPositions != null){
                    for(Integer next : nextPositions){
                        LinkedList<Integer> candidate = (LinkedList<Integer>)queue.getFirst().clone();
                        candidate.addLast(next);
                        queue.addLast(candidate);
                    }
                }
                queue.removeFirst();
            }
        }
        return res;
    }
}
