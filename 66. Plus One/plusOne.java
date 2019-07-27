class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length];
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; i--) {
            ans[i] = digits[i] % 10;
            digits[i - 1] += digits[i] / 10;
        }
        ans[0] = digits[0];
        if (ans[0] < 10) return ans;
        int[] newAns = new int[digits.length + 1];
        newAns[0] = 1;
        return newAns;
    }
}
