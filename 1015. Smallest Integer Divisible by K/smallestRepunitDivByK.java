class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)   return -1;
        int count = 1, N = 1;
        while (N % K != 0) {
            N = (N % K) * 10 + 1;
            count++;
        }
        return count;
    }
}
