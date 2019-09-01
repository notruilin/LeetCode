class Solution {    
    public int numPrimeArrangements(int n) {
        int primeNum = 0;
        boolean[] num = new boolean[n+1];
        num[1] = false;
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j <= i-1; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)  ++primeNum;
            num[i] = prime;
        }
        
        int nonPNum = n - primeNum;
        long ans = nonPNum;
        nonPNum--;
        for (int i = 2; i <= n; i++) {
            if (num[i]) {
                ans *= primeNum;
                primeNum--;
            }
            else {
                ans *= nonPNum;
                nonPNum--;
            }
            ans %= 1000000007L;
        }
        return (int) ans;
    }
}
