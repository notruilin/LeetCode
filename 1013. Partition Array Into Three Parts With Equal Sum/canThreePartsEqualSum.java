class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A.length < 3)   return false;
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i-1];
        }
        int target = A[A.length - 1] / 3;
        int i = -1, j = -1;
        for (int k = 0; k < A.length - 1; k++) {
            if (A[k] == target) {
                i = k;
                break;
            }
        }
        if (i == -1)    return false;
        for (int k = A.length - 2; k > i; k--) {
            if (A[k] == target * 2) {
                j = k;
                break;
            }
        }
        if (j == -1)    return false;
        if (i < j)  return true;
        return false;
    }
}
