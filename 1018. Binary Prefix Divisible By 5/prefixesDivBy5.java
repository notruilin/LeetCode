class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int x = 0;
        List<Boolean> ans = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            x = x << 1;
            x |= A[i];
            if (x % 5 == 0) {
                ans.add(true);
            }
            else {
                ans.add(false);
            }
            x %= 5;
        }
        return ans;
    }
}
