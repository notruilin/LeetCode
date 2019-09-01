class Solution {
    int sum[][] = new int[30][100005];
    
    private int getNum(char c, int left, int right) {
        int cn = c - 'a';
        int tmp = 0;
        if (left - 1 >= 0)  tmp = sum[cn][left-1];
        return sum[cn][right] - tmp;
    }
    
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        sum[s.charAt(0) - 'a'][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int c = 'a' - 'a'; c <= 'z' - 'a'; c++) {
                sum[c][i] = sum[c][i-1];
            }
            sum[s.charAt(i) - 'a'][i]++;
        }
        
        List<Boolean> res = new ArrayList();
        
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1], k = queries[i][2];
            int count = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                int num = getNum(c, left, right);
                num %= 2;
                count += num;
            }
            count--;
            if (count - k*2 <= 0) res.add(true);
            else    res.add(false);
        }
        return res;
    }
}
