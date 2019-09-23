class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor && divisor == Integer.MIN_VALUE)   return 1;
        if (divisor == Integer.MIN_VALUE)   return 0;
        boolean negative = false;
        if (dividend < 0)   negative = !negative;
        if (divisor < 0)   negative = !negative;
        int dividendL = Math.abs(dividend);
        int divisorL = Math.abs(divisor);
        int ans = 0, mul = 1, mulDivisor = divisorL;
        while (dividendL == Integer.MIN_VALUE || dividendL >= divisorL) {
            if (dividendL == Integer.MIN_VALUE || dividendL >= mulDivisor) {
                if (dividendL == Integer.MIN_VALUE) {
                    dividendL += mulDivisor;
                    dividendL = -dividendL;
                }
                else {
                    dividendL -= mulDivisor;
                }
                ans += mul;
                if (mulDivisor < 10000000) {
                    mulDivisor += mulDivisor;
                    mul += mul;
                }
            }
            else {
                if (mulDivisor > divisorL) {
                    mulDivisor = mulDivisor >> 1;
                    mul = mul >> 1;
                }
            }
        }
        if (!negative) {
            if (ans == Integer.MIN_VALUE)
                ans++;
            ans = Math.abs(ans);
        }
        else {
            if (ans > 0)
                ans = -ans;
        }
        return ans;
    }
}
