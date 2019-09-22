class Solution {
    private long GCD(long a, long b) {
       if (b==0) return a;
       return GCD(b,a%b);
    }
    
    private long LCM(long a, long b) {
        return (a*b / GCD(a,b));
    }
    
    private long LCM(long a, long b, long c) {
        return LCM(LCM(a, b), c); 
    }
    
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 0, right = 2000000000;
        while (left < right) {
            long mid = (left+right)/2;
            long count = mid / a + mid / b + mid / c;
            count -= mid / LCM(a,b);
            count -= mid / LCM(a,c);
            count -= mid / LCM(b,c);
            count += mid / LCM(a,b,c);
            if (count < n) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return (int)left;
    }
}
