class Solution {
    ArrayList<Integer> chars = new ArrayList();
    List<String> arr = new ArrayList();
    int ans = 0, N;
    
    void dfs(int i, int exist, int len) {
        if (i == N) {
            if (len > ans)  ans = len;
            return;
        }
        dfs(i+1, exist, len);
        if (chars.get(i) != -1 && (chars.get(i) & exist) == 0) {
            dfs(i+1, (exist | chars.get(i)), len + arr.get(i).length());
        }
    }
    
    public int maxLength(List<String> arr) {
        N = arr.size();
        this.arr = arr;
        chars = new ArrayList();
        for (String str: arr) {
            int h = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if ((h & (1 << (c-'a'))) > 0)   h = -1;
                else    h = h | (1 << (c-'a'));
            }
            chars.add(h);
        }
        
        dfs(0, 0, 0);
        return ans;
    }
}
