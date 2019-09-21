class Solution {
    int MAXN = 100005;
    List<Integer>[] edges = new ArrayList[MAXN];
    int[] dfn = new int[MAXN];
    int[] low = new int[MAXN];
    int[] father = new int[MAXN];
    int index = 0;
    
    private void tarjan(int i) {
        dfn[i] = low[i] = ++index;
        for (int j: edges[i]) {
            if (dfn[j] == 0) {
                father[j] = i;
                tarjan(j);
                low[i] = Math.min(low[i], low[j]);
            }
            else {
                if (father[i] != j)
                    low[i] = Math.min(low[i], dfn[j]);
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<Integer>();
        for (int i = 0; i < connections.size(); i++) {
            edges[connections.get(i).get(0)].add(connections.get(i).get(1));
            edges[connections.get(i).get(1)].add(connections.get(i).get(0));
        }
        tarjan(0);
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            if ((dfn[u] < low[v] && father[v] == u) || (dfn[v] < low[u] && father[u] == v)) {
                List<Integer> e = new ArrayList();
                e.add(u);
                e.add(v);
                ans.add(e);
            }
        }
        return ans;
    }
}
