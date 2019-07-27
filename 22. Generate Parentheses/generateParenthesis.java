class Solution {
    List<String> ans = new ArrayList();
    
    public void dfs(int i, int n, String s, int left, int right) {
        if (i == n*2 + 1) {
            ans.add(s);
            return;
        }
        for (int k = 0; k <= 1; k++) {
            if (k == 0) {
                if (left < n)   dfs(i+1, n, s+'(', left+1, right);
            }
            else {
                if (right < left)   dfs(i+1, n, s+')', left, right+1);
            }
        }
    }
    
    public List<String> generateParenthesis(int n) {
        dfs(1, n, new String(), 0, 0);
        return ans;
    }
    
}
