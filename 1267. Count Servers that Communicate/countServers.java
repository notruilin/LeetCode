class Solution {
    public int countServers(int[][] grid) {
        int M = grid.length, ans = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < M; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    map.put(j+M, map.getOrDefault(j+M, 0) + 1);
                }
        for (int i = 0; i < M; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    if (map.get(i) != 1 || map.get(j+M) != 1)
                        ++ans;
        return ans;
    }
}
