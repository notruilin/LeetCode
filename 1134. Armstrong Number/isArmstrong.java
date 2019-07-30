class Solution {
    public boolean isArmstrong(int N) {
        for (int i = 0; ; i++) {
            int n = N, count = 0;
            while(n > 0) {
                count += Math.pow(n%10, i);
                n /= 10;
            }
            if (count == N) return true;
            if (count > N)  return false;
        }
    }
}
