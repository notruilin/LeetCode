class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0)   return false;
        int part = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            part += A[i];
            if (part == sum / 3) {
                ++count;
                part = 0;
            }
        }
        if (count == 3) return true;
        return false;
    }
}
