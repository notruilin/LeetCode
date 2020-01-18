class Solution {
    List<List<Integer>> ans = new ArrayList();
    List<Integer> lst = new ArrayList();
    boolean[][] f;
    
    private void dfsAns(int[] candidates, int target, int i) {
        if (target == 0) {
            List<Integer> newLst = new ArrayList();
            for (int x: lst) newLst.add(x);
            ans.add(newLst);
            return;
        }
        if (i - 1 >= 0 && f[i-1][target])    dfsAns(candidates, target, i-1);
        if (target - candidates[i] >= 0 && f[i][target - candidates[i]]) {
            lst.add(candidates[i]);
            dfsAns(candidates, target - candidates[i], i);
            lst.remove(lst.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        f = new boolean[candidates.length][target + 1];
        for (int i = 0; i < candidates.length; i++) {
            f[i][0] = true;
            for (int sum = 0; sum <= target; sum++) {
                int x = candidates[i];
                if (i - 1 >= 0)  f[i][sum] = f[i][sum] || f[i-1][sum];
                if (sum - x >= 0)    f[i][sum] = f[i][sum] || f[i][sum - x];
            }
        }
        dfsAns(candidates, target, candidates.length - 1);
        return ans;
    }
}
