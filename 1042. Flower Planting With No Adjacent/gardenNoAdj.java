class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        ArrayList[] g = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) 
            g[i] = new ArrayList<Integer>();
        for (int i = 0; i < paths.length; i++) {
            g[paths[i][0]].add(paths[i][1]);
            g[paths[i][1]].add(paths[i][0]);
        }
        
        int[] ans = new int[N];
        
        boolean[][] nonColor = new boolean[N+1][5];
        Queue<Integer> queue = new LinkedList();
        for (int j = 1; j <= N; j++) {
            if (ans[j-1] == 0)    queue.add(j);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                int color = 1;
                while (color <= 4 && nonColor[node][color]) ++color;
                ans[node-1] = color;
                for (int i = 0; i < g[node].size(); i++) {
                    Integer next = (Integer)g[node].get(i);
                    if (ans[next-1] == 0) {
                        nonColor[next][color] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return ans;
    }
}
