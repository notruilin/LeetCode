class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList();
        for (int[] interval: intervals) {
            if (interval[1] < toBeRemoved[0] || interval[0] > toBeRemoved[1]) {
                ans.add(Arrays.asList(interval[0], interval[1]));
            }
            else {
                if (toBeRemoved[0] > interval[0])
                    ans.add(Arrays.asList(interval[0], toBeRemoved[0]));
                if (toBeRemoved[1] < interval[1])
                    ans.add(Arrays.asList(toBeRemoved[1], interval[1]));
            }
            
        }
        return ans;
    }
}
