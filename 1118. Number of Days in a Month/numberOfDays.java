class Solution {
    public int numberOfDays(int Y, int M) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int ans = days[M-1];
        if (Y%4 == 0 && Y%100 != 0 && M == 2) ans++;
        else {
            if (Y%400 == 0 && M == 2)
                ans++;
        }
        return ans;
    }
}
