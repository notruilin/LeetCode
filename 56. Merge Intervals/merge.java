class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)   return intervals;
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> res = new ArrayList();
        res.add(intervals[0]);
        for (int[] interval: intervals) {
            if (interval[0] <= res.get(res.size()-1)[1]) {
                res.get(res.size()-1)[0] = Math.min(interval[0], res.get(res.size()-1)[0]);
                res.get(res.size()-1)[1] = Math.max(interval[1], res.get(res.size()-1)[1]);
            }
            else res.add(interval);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
