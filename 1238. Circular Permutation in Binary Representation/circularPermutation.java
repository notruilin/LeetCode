class Solution {
    ArrayList<Integer> ends;
    int num, n;
    ArrayList<Integer> ans = new ArrayList();
    ArrayList<Integer> tryAns = new ArrayList();
    boolean[] exist = new boolean[70000];
    boolean getAns = false;
    
    void dfs(int cur, int end, int i) {
        //System.out.println(tryAns.toString());
        if (getAns) return;
        for (int j = 0; j < n; j++) {
            int next = cur ^ (1<<j);
            //System.out.println("next: " + next);
            if (!exist[next]) {
                //System.out.println("i == num: " + (i == num) + " " + i + " " + num);
                if (i == num) {
                    if (next == end) {
                        getAns = true;
                        for (int x: tryAns) ans.add(x);
                        ans.add(end);
                        return;
                    }
                }
                else {
                    if (next != end) {
                        exist[next] = true;
                        tryAns.add(next);
                        dfs(next, end, i+1);
                        exist[next] = false;
                        tryAns.remove(tryAns.size()-1);
                    }
                }
            }
        }
    }
    
    public List<Integer> circularPermutation(int n, int start) {
        this.n = n;
        num = (int)Math.pow(2, n) - 1;
        ends = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int end = start ^ (1<<i);
            ends.add(end);
        }
        
        tryAns.add(start);
        exist[start] = true;
        for (int end: ends) {
            //System.out.println("end: " + end);
            dfs(start, end, 1);
            if (getAns) break;
        }
        
        return ans;
    }
}
