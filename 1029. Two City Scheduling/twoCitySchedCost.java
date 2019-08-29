class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b) -> Integer.compare(-Math.abs(a[0]-a[1]), -Math.abs(b[0]-b[1])));
        int N1 = 0 , N2 = 0, N = costs.length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if ((N1 < N/2 && costs[i][0] < costs[i][1]) || N2 == N/2) {
                ans += costs[i][0];
                ++N1;
            }
            else {
                ans += costs[i][1];
                ++N2;
            }
        }
        return ans;
    }
}
