class Solution {
    public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0 && A[i] == i) return i;
        }
        return -1;
    }
}
