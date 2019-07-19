class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[][] f = new int[books.length + 1][shelf_width + 1];
        int[][] h = new int[books.length + 1][shelf_width + 1];
        for (int i = 0; i <= books.length; i++) 
            for (int j = 0; j <= shelf_width; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        f[0][shelf_width] = 0;
        h[0][shelf_width] = 0;
        
        for (int i = 1; i <= books.length; i++) {
            int height = books[i-1][1];
            int width = books[i-1][0];
            for (int j = 0; j <= shelf_width - width; j++) {
                if (f[i-1][j + width] < Integer.MAX_VALUE) {
                    f[i][j] = f[i-1][j + width];
                    h[i][j] = h[i-1][j + width];
                    if (h[i-1][j + width] < height) {
                        f[i][j] += height - h[i-1][j + width];
                        h[i][j] = height;
                    }
                }
            }
            for (int j = 0 ; j <= shelf_width; j++) {
                if (f[i-1][j] < Integer.MAX_VALUE) {
                    f[i][shelf_width - width] = Math.min(f[i][shelf_width - width], f[i-1][j] + height);
                    h[i][shelf_width - width] = height;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= shelf_width; j++) {
            ans = Math.min(ans, f[books.length][j]);
        }
        return ans;
    }
}
