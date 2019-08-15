class Solution {
    HashMap<Character, Integer> map = new HashMap();
    int count = 0;
    
    private void dfs(int n) {
        for (Character c: map.keySet()) {
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
                ++count;
                dfs(n+1);
                map.put(c, map.get(c) + 1);
            }
        }
    }
    
    public int numTilePossibilities(String tiles) {
        for (int i = 0; i < tiles.length(); i++) {
            if (map.containsKey(tiles.charAt(i))) {
                map.put(tiles.charAt(i), map.get(tiles.charAt(i)) + 1);
            }
            else {
                map.put(tiles.charAt(i), 1);
            }
        }
        dfs(0);
        return count;
    }
}
