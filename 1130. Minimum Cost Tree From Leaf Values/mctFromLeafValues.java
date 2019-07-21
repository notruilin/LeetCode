class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] maxValue = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                maxValue[i][j] = arr[i];
                for (int k = i + 1; k <= j; k++) {
                    maxValue[i][j] = Math.max(maxValue[i][j], arr[k]);
                }
            }
        }
        int[][] f = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
            f[i][i] = arr[i];
        }
        for (int l = 1; l < arr.length; l++) {
            for (int i = 0; i < arr.length; i++) {
                if (i + l >= arr.length)    break;
                for (int k = i; k < i + l; k++) {
                    f[i][i+l] = Math.min(f[i][i+l], f[i][k] + f[k+1][i+l] + maxValue[i][k] * maxValue[k+1][i+l]);
                }
            }
        }
        return f[0][arr.length-1] - Arrays.stream(arr).sum();
    }
}
