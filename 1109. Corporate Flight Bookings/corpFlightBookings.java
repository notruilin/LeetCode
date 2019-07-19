class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] f = new int[n + 2];
        for (int i = 0; i < bookings.length; i++) {
            f[bookings[i][0]] += bookings[i][2];
            f[bookings[i][1] + 1] -= bookings[i][2];
        }
        int[] ans = new int[n];
        ans[0] = f[1];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1] + f[i+1];
        }
        return ans;
    }
}
