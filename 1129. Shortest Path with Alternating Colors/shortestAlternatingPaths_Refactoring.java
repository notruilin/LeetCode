class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<List<Integer>> map = new ArrayList();
        for (int i = 0; i < n*2; i++) {
            map.add(new ArrayList());
        }
        for (int i = 0; i < red_edges.length; i++) {
            map.get(red_edges[i][0]).add(red_edges[i][1] + n);
        }
        for (int i = 0; i < blue_edges.length; i++) {
            map.get(blue_edges[i][0] + n).add(blue_edges[i][1]);
        }
        List<Integer> queue = new ArrayList();
        int[] d = new int[n*2];
        Arrays.fill(d, Integer.MAX_VALUE);
        queue.add(0);
        queue.add(n);
        d[0] = 0;
        d[n] = 0;
        while (queue.size() > 0) {
            int u = queue.remove(0);
            for (int i = 0; i < map.get(u).size(); i++) {
                int v = map.get(u).get(i);
                if (d[v] == Integer.MAX_VALUE) {
                    d[v] = d[u] + 1;
                    queue.add(v);
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(d[i], d[i+n]);
            if (ans[i] == Integer.MAX_VALUE)    ans[i] = -1;
        }
        return ans;
    }
}
