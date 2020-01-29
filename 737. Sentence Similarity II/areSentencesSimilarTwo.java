class Solution {
    int[] father = new int[2005];
    
    private int find(int x) {
        if (father[x] == x) return x;
        return father[x] = find(father[x]);
    }
    
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        father[x] = y;
    }
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        
        int id = 0;
        Map<String, Integer> map = new HashMap();
        
        for (List<String> pair: pairs) {
            String a = pair.get(0), b = pair.get(1);
            if (!map.containsKey(a)) {
                father[id] = id;
                map.put(a, id++);
            }
            if (!map.containsKey(b)) {
                father[id] = id;
                map.put(b, id++);
            }
            int idA = map.get(a), idB = map.get(b);
            union(idA, idB);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i]))    continue;
            int idA = map.getOrDefault(words1[i], -1);
            int idB = map.getOrDefault(words2[i], -1);
            if (idA == -1 || idB == -1) return false;
            if (find(idA) != find(idB)) return false;
        }
        
        return true;
    }
}
