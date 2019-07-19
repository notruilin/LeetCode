class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int f[] = new int[books.length + 1];
        f[0] = 0;
        for (int i = 1; i <= books.length; i++) {
            int width = books[i-1][0];
            int height = books[i-1][1];
            f[i] = f[i-1] + height;
            int sum = width;
            int maxH = height;
            for (int j = i - 1; j > 0 && sum + books[j-1][0] <= shelf_width; j--) {
                sum += books[j-1][0];
                maxH = Math.max(maxH, books[j-1][1]);
                f[i] = Math.min(f[i], f[j-1] + maxH);
            }
        }
        return f[books.length];
    }
}
