class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> map = new HashMap();
        
        for (List<String> pair: pairs) {
            String a = pair.get(0), b = pair.get(1);
            if (!map.containsKey(a))    map.put(a, new HashSet());
            map.get(a).add(b);
            if (!map.containsKey(b))    map.put(b, new HashSet());
            map.get(b).add(a);
        }
        
        for (int i = 0; i < words1.length; i++) {
            String a = words1[i], b = words2[i];
            if (words1[i].equals(words2[i]))    continue;
            if (!map.containsKey(a))    return false;
            if (!map.get(a).contains(b))    return false;
        }
        
        return true;
    }
}
