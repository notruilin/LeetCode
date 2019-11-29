class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> matrix = new ArrayList();
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        
        for (int i = 0; i < colsum.length; i++) {
            int a = 0, b = 0;
            if (colsum[i] == 2) {
                a = 1;
                b = 1;
            }
            if (colsum[i] == 1) {
                if (upper > lower)  a = 1;
                else    b = 1;
            }
            matrix.get(0).add(a);
            matrix.get(1).add(b);
            upper -= a;
            lower -= b;
        }
        
        if (upper == 0 && lower == 0)   return matrix;
        return new ArrayList();
    }
}
