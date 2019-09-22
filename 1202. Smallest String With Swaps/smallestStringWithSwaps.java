class Solution {
    List<Integer>[] edges = new ArrayList[100005];
    boolean[] vis = new boolean[100005];
    char[] str = new char[100005];
    List<Integer> path;
    
    void dfs(int i) {
        vis[i] = true;
        path.add(i);
        for (int j: edges[i]) {
            if (!vis[j]) 
                dfs(j);
        }
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int N = s.length();
        for (int i = 0; i < N; i++) {
            str[i] = s.charAt(i);
            edges[i] = new ArrayList<Integer>();
        }
        for (List<Integer> pair: pairs) {
            edges[pair.get(0)].add(pair.get(1));
            edges[pair.get(1)].add(pair.get(0));
        }
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                path = new ArrayList<Integer>();
                dfs(i);
                char[] cs = new char[path.size()];
                for (int index = 0; index < path.size(); index++) {
                    cs[index] = str[path.get(index)];
                }
                Arrays.sort(cs);
                Collections.sort(path);
                for (int index = 0; index < path.size(); index++) {
                    str[path.get(index)] = cs[index];
                }
            }
        }
        return new String(str, 0, N);
    }
}
