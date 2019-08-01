class Solution {
    public int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i+1]) {
                int maxIndex = i+1;
                for (int j = i+1; j < A.length; j++) {
                    if (A[j] < A[i] && A[j] > A[maxIndex])
                        maxIndex = j;
                }
                int tmp = A[i];
                A[i] = A[maxIndex];
                A[maxIndex] = tmp;
                break;
            }
        }
        return A;
    }
}
