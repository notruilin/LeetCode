class Solution {
    int MAXN = 30001;
    List<Integer>[] edge = new ArrayList[MAXN*2];
    List<Integer>[] groupMember = new ArrayList[MAXN];
    int[] inCount = new int[MAXN*2];
    boolean[] vis = new boolean[MAXN*2];
    List<Integer>[] sortedLst = new ArrayList[MAXN*2];
    
    private List<Integer> getOrder(List<Integer> items) {
        List<Integer> lst = new ArrayList();
        while (true) {
            boolean find = false;
            for (int item: items) {
                if (!vis[item] && inCount[item] == 0) {
                    lst.add(item);
                    vis[item] = true;
                    find = true;
                    for (int j: edge[item]) {
                        inCount[j]--;
                    }
                }
            }
            if (!find)  break;
        }
        return lst;
    }
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n+m; i++)
            edge[i] = new ArrayList<Integer>();
        for (int i = 0; i < m; i++)
            groupMember[i] = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            if (group[i] != -1)
                groupMember[group[i]].add(i);
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j: beforeItems.get(i)) {
                if (group[i] == group[j] && group[i] != -1) {
                    edge[j].add(i);
                    inCount[i]++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            sortedLst[i] = getOrder(groupMember[i]);
            if (sortedLst[i].size() != groupMember[i].size()) {
                return new int[]{};
            }
        }
        
        for (int i = 0; i < n+m; i++)
            edge[i].clear();
        Arrays.fill(inCount, 0);
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j: beforeItems.get(i)) {
                if (group[i] != group[j]) {
                    int indexI = group[i] == -1 ? i : n+group[i];
                    int indexJ = group[j] == -1 ? j : n+group[j];
                    edge[indexJ].add(indexI);
                    inCount[indexI]++;
                }
            }
        }
        
        List<Integer> nodes = new ArrayList();
        for (int i = 0; i < n; i++)
            if (group[i] == -1)
                nodes.add(i);
        for (int i = 0; i < m; i++)
            if (groupMember[i].size() > 0)
                nodes.add(n+i);
        
        List<Integer> lst = getOrder(nodes);
        if (lst.size() != nodes.size())
            return new int[]{};
        System.out.println(lst.toString());
        int[] ans = new int[n];
        int count = 0;
        for (int item: lst) {
            if (item >= n) {
                for (int j: sortedLst[item-n]) {
                    ans[count++] = j;
                }
            }
            else ans[count++] = item;
        }
        
        return ans;
    }
}
