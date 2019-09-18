class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        String[][] str = new String[matrix.length][2];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            str[i][0] = new String();
            str[i][1] = new String();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    str[i][0] += " " + j;
                }
                else {
                    str[i][1] += " " + j;
                }
            }
            if (str[i][0].length() == 0 || str[i][1].length() == 0) ++ans;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int num = 0; num <= 1; num++) {
                int count = 0;
                for (int j = 0; j < matrix.length; j++) {
                    if (str[i][num].equals(str[j][0]) || str[i][num].equals(str[j][1])) {
                        ++count;
                    }
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
