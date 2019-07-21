class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] count = new int[10][10];
        for (int i = 0; i < dominoes.length; i++) {
            int a = dominoes[i][0], b = dominoes[i][1];
            if (b < a) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            ++count[a][b];
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (count[i][j] > 1) {
                    ans += (count[i][j] - 1) * count[i][j] / 2;
                }
            }
        }
        return ans;
    }
}
