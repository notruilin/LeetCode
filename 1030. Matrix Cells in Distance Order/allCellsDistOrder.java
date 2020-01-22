class Solution {
    private int r0, c0;
    
    private int manhattan(int[] pos) {
        return Math.abs(pos[0] - r0) + Math.abs(pos[1] - c0);
    }
    
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        this.r0 = r0;
        this.c0 = c0;
        int[][] pos = new int[R*C][2];
        int count = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                pos[count][0] = i;
                pos[count][1] = j;
                ++count;
            }
        Arrays.sort(pos, (a, b) -> Integer.compare(manhattan(a), manhattan(b)));
        return pos;
    }
}
