class Solution {
    List<List<Integer>> ans = new ArrayList();;
    List<Integer> lst = new ArrayList();
    
    private void dfs(int[] candidates, int target, int now, int index) {
        if (now >= target) {
            if (now == target) {
                List<Integer> newLst = new ArrayList<Integer>();
                for (int x: lst)    newLst.add(x);
                ans.add(newLst);
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            lst.add(candidates[i]);
            dfs(candidates, target, now + candidates[i], i);
            lst.remove(lst.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, 0);
        return ans;
    }
}
