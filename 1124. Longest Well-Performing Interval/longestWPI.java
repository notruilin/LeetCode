class Solution {
    private List<Integer> monoQue = new ArrayList();
    private int[] sum = new int[10002];
    private int ans = 0;
    
    private void binarySearch(int i) {
        int l = 0, r = monoQue.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (sum[i] - sum[monoQue.get(mid)] > 0) 
                r = mid;
            else
                l = mid + 1;
        }
        if (l > r || sum[i] - sum[monoQue.get(l)] <= 0) return;
        ans = Math.max(ans, i - monoQue.get(l));
    }
    
    public int longestWPI(int[] hours) {
        for (int i = 0; i < hours.length; i++)
            hours[i] = hours[i] > 8? 1 : -1;
        sum[0] = 0;
        for (int i = 0; i < hours.length; i++)
            sum[i+1] += sum[i] + hours[i];
        monoQue.add(0);
        for (int i = 1; i <= hours.length; i++) {
            if (sum[i] < sum[monoQue.get(monoQue.size() - 1)])   monoQue.add(i);
            binarySearch(i);
        }
        return ans;
    }
}
