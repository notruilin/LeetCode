class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedH = new int[heights.length];
        for (int i = 0; i < heights.length; i++)    sortedH[i] = heights[i];
        Arrays.sort(sortedH);
        int ans = 0;
        for (int i = 0; i < sortedH.length; i++) {
            if (sortedH[i] != heights[i])    ++ans;
        }
        return ans;
    }
}
