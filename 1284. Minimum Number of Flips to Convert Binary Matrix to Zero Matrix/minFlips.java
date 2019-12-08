class Solution {
    int m, n;
    
    class Node {
        public int[][] mat;
        public int cost;
        public Node(int[][] mat, int cost) {
            this.mat = mat;
            this.cost = cost;
        }
    }
    
    int toInt(int[][] mat) {
        int num = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                num = (num * 10) + mat[i][j];
            }
        return num;
    }
    
    boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    
    public int minFlips(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        if (toInt(mat) == 0)    return 0;
        Set<Integer> set = new HashSet();
        List<Node> lst = new ArrayList();
        lst.add(new Node(mat, 0));
        set.add(toInt(mat));
        while (lst.size() > 0) {
            mat = lst.get(0).mat;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    int[][] newMat = new int[m][n];
                    for (int p = 0; p < m; p++)
                        for (int q = 0; q < n; q++) {
                            newMat[p][q] = mat[p][q];
                        }
                    newMat[i][j] = 1 - newMat[i][j];
                    for (int dx = -1; dx <= 1; dx++)
                        for (int dy = -1; dy <= 1; dy++)
                            if (Math.abs(dx)+Math.abs(dy) == 1) {
                                if (isValid(i+dx,j+dy))
                                    newMat[i+dx][j+dy] = 1 - newMat[i+dx][j+dy];
                            }
                    int hash = toInt(newMat);
                    if (hash == 0)  return lst.get(0).cost + 1;
                    if (!set.contains(hash)) {
                        lst.add(new Node(newMat, lst.get(0).cost + 1));
                        set.add(hash);
                    }
            }
            lst.remove(0);
        }
        return -1;
    }
}
