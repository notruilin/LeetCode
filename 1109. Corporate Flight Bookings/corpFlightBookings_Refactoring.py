class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] f = new int[n];
        for (int[] k: bookings) {
            f[k[0] - 1] += k[2];
            if (k[1] < n)   f[k[1]] -= k[2];
        }
        for (int i = 1; i < n; i++) f[i] += f[i-1];
        return f;
    }
}
