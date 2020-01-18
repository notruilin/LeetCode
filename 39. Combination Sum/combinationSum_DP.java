class Solution {
    List<Integer>[] f;
    List<List<Integer>> ans = new ArrayList();
    List<Integer> lst = new ArrayList();
    
    private void dfs(int target, int last) {
        if (target == 0) {
            List<Integer> newLst = new ArrayList();
            for (int x: lst)    newLst.add(x);
            ans.add(newLst);
            return;
        }
        for (int x: f[target]) {
            if (last >= target - x) {
                lst.add(target - x);
                dfs(x, target - x);
                lst.remove(lst.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        f = new ArrayList[target + 1];
        Arrays.sort(candidates);
        for (int sum = candidates[0]; sum <= target; sum++) {
            f[sum] = new ArrayList();
            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i] > sum)    break;
                if (sum - candidates[i] == 0 || (sum - candidates[i] > 0 && f[sum-candidates[i]] != null && f[sum-candidates[i]].size() > 0)) {
                    f[sum].add(sum - candidates[i]);
                }
            }
        }
        if (f[target] != null)  dfs(target, Integer.MAX_VALUE);
        return ans;
    }
}
