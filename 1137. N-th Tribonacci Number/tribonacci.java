class Solution {
    public int tribonacci(int n) {
        int[] num = new int[n + 3];
        num[0] = 0;
        num[1] = 1;
        num[2] = 1;
        for (int i = 3; i <= n; i++) {
            num[i] = num[i-3] + num[i-2] + num[i-1];
        }
        return num[n];
    }
}
