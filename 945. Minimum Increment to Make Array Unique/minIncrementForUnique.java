class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i-1]) {
                int c = A[i-1] + 1 - A[i];
                A[i] = A[i-1] + 1;
                count += c;
            }
        }
        return count;
    }
}
