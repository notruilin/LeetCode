class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int x: arr1) count[x]++;
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x: arr2) {
            for (int i = 0; i < count[x]; i++) {
                ans[index++] = x;
            }
            count[x] = 0;
        }
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < count[i]; j++) {
                ans[index++] = i;
            }
        }
        return ans;
    }
}
