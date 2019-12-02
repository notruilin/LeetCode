class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < toBeRemoved[0] || intervals[i][0] > toBeRemoved[1]) {
                ans.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
                continue;
            }
            if (intervals[i][0] >= toBeRemoved[0] && intervals[i][1] <= toBeRemoved[1])   continue;
            if (intervals[i][0] <= toBeRemoved[0] && intervals[i][1] >= toBeRemoved[1]) {
                if (intervals[i][0] != toBeRemoved[0])
                    ans.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], toBeRemoved[0])));
                if (toBeRemoved[1] != intervals[i][1])
                    ans.add(new ArrayList<Integer>(Arrays.asList(toBeRemoved[1], intervals[i][1])));
                continue;
            }
            if (intervals[i][1] >= toBeRemoved[1]) {
                ans.add(new ArrayList<Integer>(Arrays.asList(toBeRemoved[1], intervals[i][1])));
                continue;
            }
            if (toBeRemoved[0] <= intervals[i][1]) {
                ans.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], toBeRemoved[0])));
            }
        }
        return ans;
    }
}
