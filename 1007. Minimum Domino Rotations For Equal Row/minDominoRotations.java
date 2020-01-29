class Solution {
    private int check(int[] A, int[] B, int target) {
        int countA = 0, countB = 0;
        boolean valid = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] == target)   countA++;
            if (B[i] != target && A[i] == target)   countB++;
            if (A[i] != target && B[i] != target) {
                valid = false;
                break;
            }
        }
        if (valid)  return Math.min(countA, countB);
        else    return -1;
    }
    
    public int minDominoRotations(int[] A, int[] B) {
        int ans1 = check(A, B, A[0]);
        int ans2 = check(A, B, B[0]);
        if (ans2 == -1 || (ans1 != -1 && ans1 < ans2))
            return ans1;
        return ans2;
    }
}
