class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int[] sum = new int[100001];
        int N = calories.length;
        sum[0] = calories[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + calories[i];
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (i+k-1 >= N) break;
            int left = 0;
            if (i-1 >= 0)   left = sum[i-1];
            int right = sum[N-1];
            if (i+k-1 < N) right = sum[i+k-1];
            int x = right - left;
            if (x < lower)  ans--;
            if (x > upper)  ans++;
        }
        return ans;
    }
}
