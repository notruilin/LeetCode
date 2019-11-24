class Solution {
    private int dis(int[] pos1, int[] pos2) {
        return Math.max(Math.abs(pos1[0] - pos2[0]), Math.abs(pos1[1] - pos2[1]));
    }
    
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++)
            ans += dis(points[i-1], points[i]);
        return ans;
    }
}
