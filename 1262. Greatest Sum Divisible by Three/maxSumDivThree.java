class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0, one = 999999, two = 999999;
        for (int x: nums) {
            sum += x;
            if (x % 3 == 1) {
                two = Math.min(two, one + x);
                one = Math.min(one, x);
            }
            if (x % 3 == 2) {
                one = Math.min(one, two + x);
                two = Math.min(two, x);
            }
        }
        if (sum % 3 == 1)   sum -= one;
        if (sum % 3 == 2)   sum -= two;
        return sum;
    }
}
