class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while (k > 0) {
            k--;
            int last = grid[grid.length-1][grid[0].length-1];
            for (int i = grid.length - 1; i >= 0; i--)
                for (int j = grid[0].length - 1; j >= 0 ; j--)
                    if (j - 1 >= 0)
                        grid[i][j] = grid[i][j-1];
                    else
                        if (i-1 >= 0)
                            grid[i][j] = grid[i-1][grid[0].length-1];
                        else
                            grid[i][j] = last;
        }
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            ans.add(new ArrayList<Integer>());
            for (int x: grid[i])
                ans.get(ans.size()-1).add(x);
        }
        return ans;
    }
}
