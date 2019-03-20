class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while (N > 0) {
            int tmp = N % 2;
            nums.add(1 - N%2);
            N = N >> 1;
        }
        int ans = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            ans = ans << 1 | nums.get(i);
        }
        return ans;
    }
}
