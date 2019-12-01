class Solution {
    int[][] matrix;
    
    boolean isAllOne(int x, int y, int size) {
        if (x + size >= matrix.length || y + size >= matrix[0].length)
            return false;
        int sum = matrix[x + size][y + size];
        if (x - 1 >= 0)
            sum -= matrix[x-1][y+size];
        if (y - 1 >= 0)
            sum -= matrix[x+size][y-1];
        if (x - 1 >= 0 && y - 1 >= 0)
            sum += matrix[x-1][y-1];
        if (sum == (size + 1) * (size + 1))
            return true;
        return false;
    }
    
    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (i - 1 >= 0)
                    matrix[i][j] += matrix[i-1][j];
                if (j - 1 >= 0)
                    matrix[i][j] += matrix[i][j-1];
                if (i-1 >= 0 && j - 1 >= 0)
                    matrix[i][j] -= matrix[i-1][j-1];
            }
        
        int ans = 0;
        
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                for (int size = 0; size < Math.min(matrix.length, matrix[0].length); size++) {
                    if (isAllOne(i, j, size))
                        ++ans;
                }
        
        return ans;
    }
}
