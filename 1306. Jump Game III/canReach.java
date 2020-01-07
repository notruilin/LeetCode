class Solution {
    boolean[] visited = new boolean[50005];
    boolean find = false;
    int[] arr;
    int N;
    
    void dfs(int node) {
        if (arr[node] == 0) find = true;
        if (find)   return;
        if (node + arr[node] < N && !visited[node + arr[node]]) {
            visited[node + arr[node]] = true;
            dfs(node + arr[node]);
        }
        if (node - arr[node] >= 0 && !visited[node - arr[node]]) {
            visited[node - arr[node]] = true;
            dfs(node - arr[node]);
        }
    }
    
    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        N = arr.length;
        visited[start] = true;
        dfs(start);   
        return find;
    }
}
