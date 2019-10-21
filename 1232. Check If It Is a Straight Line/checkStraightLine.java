class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        float k = (float)(coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            float tk = (float)(coordinates[i][1] - coordinates[i-1][1]) / (coordinates[i][0] - coordinates[i-1][0]);
            if (Float.compare(Math.abs(k), Math.abs(tk)) != 0)
                return false;
        }
        return true;
    }
}
