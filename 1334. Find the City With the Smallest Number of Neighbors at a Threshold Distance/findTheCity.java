class Solution {
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dis[i][j] = Integer.MAX_VALUE;
            dis[i][i] = 0;
        }
        for (int i = 0; i < edges.length; i++) {
            dis[edges[i][0]][edges[i][1]] = edges[i][2];
            dis[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
        int ans = 0, minNum = Integer.MAX_VALUE, count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (dis[i][j] <= distanceThreshold)  count++;
            }
            if (count <= minNum) {
                minNum = count;
                ans = i;
            }
        }
        return ans;
    }
}
