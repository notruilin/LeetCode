class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length];
        xor[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            xor[i] = xor[i-1] ^ arr[i];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] > 0)
                ans[i] = xor[queries[i][1]] ^ xor[queries[i][0] - 1];
            else
                ans[i] = xor[queries[i][1]];
        }
        return ans;
    }
}
