public class ValidWordAbbr {
    
    Map<String, String> map;
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String key = getHash(s);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(s))
                    map.put(key, "");
            } else {
                map.put(key, s);
            }
        }  
    }
    
    public boolean isUnique(String word) {
        String key = getHash(word);
        if (!map.containsKey(key)) return true;
        else return map.get(key).equals(word);
    }
    
    private String getHash(String word) {
        return word.length() <= 2 ? word : (word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1)); 
    }
    
}