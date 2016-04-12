public class ValidWordAbbr {
    private HashMap<String, HashSet<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, HashSet<String>>();
        if(dictionary == null || dictionary.length == 0 ){
            return;
        }
        Arrays.sort(dictionary);
        for(String str : dictionary){
            // not equals to prev
            String abbrev = shorten(str);
            if(map.get(abbrev) == null){
                HashSet<String> set = new HashSet<>();
                set.add(str);
                map.put(abbrev, set);
            }else{
                map.get(abbrev).add(str);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbrev = shorten(word);
        if(map.get(abbrev) == null){
            return true;
        }
        if(map.get(abbrev).size() > 1){
            return false;
        }
        return map.get(abbrev).contains(word);
    }

    public String shorten(String word){
        if(word.length() <= 2){
            return word;

        }else{
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0));
            sb.append(word.length()-2);
            sb.append(word.charAt(word.length()-1));
            String key = sb.toString();
            return key;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
