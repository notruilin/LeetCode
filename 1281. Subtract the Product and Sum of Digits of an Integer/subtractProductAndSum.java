class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n > 0) {
            int x = n % 10;
            n /= 10;
            product *= x;
            sum += x;
        }
        return product - sum;
    }
}
