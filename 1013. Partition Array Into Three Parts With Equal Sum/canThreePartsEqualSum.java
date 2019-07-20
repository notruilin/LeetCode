class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i-1];
        }
        if (A[A.length - 1] % 3 != 0)   return false;
        int target = A[A.length - 1] / 3;
        int i = -1, j = -1;
        for (int k = 0; k < A.length - 1; k++) {
            if (A[k] == target) {
                i = k;
                break;
            }
        }
        for (int k = A.length - 2; k > i; k--) {
            if (A[k] == target * 2) {
                j = k;
                break;
            }
        }
        if (i < j)  return true;
        return false;
    }
}
