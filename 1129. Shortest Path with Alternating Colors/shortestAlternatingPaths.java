import java.util.ArrayList;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        boolean[][] mapRed = new boolean[n][n];
        boolean[][] mapBlue = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mapRed[i], false);
            Arrays.fill(mapBlue[i], false);
        }
        for (int i = 0; i < red_edges.length; i++) {
            mapRed[red_edges[i][0]][red_edges[i][1]] = true;
        }
        for (int i = 0; i < blue_edges.length; i++) {
            mapBlue[blue_edges[i][0]][blue_edges[i][1]] = true;
        }
        int[] dLastRed = new int[n];
        int[] dLastBlue = new int[n];
        boolean[][] visited = new boolean[n][2];
        Arrays.fill(dLastRed, -1);
        Arrays.fill(dLastBlue, -1);
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        dLastRed[0] = 0;
        dLastBlue[0] = 0;
        visited[0][0] = true;
        visited[0][1] = true;
        List<Integer> queue = new ArrayList();
        List<Integer> lastColor = new ArrayList();
        queue.add(0);
        lastColor.add(0);
        queue.add(0);
        lastColor.add(1);
        while (queue.size() > 0) {
            int node = queue.remove(0);
            int color = lastColor.remove(0);
            if (color == 0) {    // nextBlue
                for (int j = 0; j < n; j++) {
                    if (mapBlue[node][j]) {
                        if (dLastBlue[j] != -1) {
                            dLastBlue[j] = Math.min(dLastBlue[j], dLastRed[node] + 1);
                        }
                        else {
                            dLastBlue[j] = dLastRed[node] + 1;
                        }
                        if (!visited[j][1]) {
                            visited[j][1] = true;
                            queue.add(j);
                            lastColor.add(1);
                        }
                    }
                }
            }
            else {  // nextRed
                for (int j = 0; j < n; j++) {
                    if (mapRed[node][j]) {
                        if (dLastRed[j] != -1) {
                            dLastRed[j] = Math.min(dLastRed[j], dLastBlue[node] + 1);
                        }
                        else {
                            dLastRed[j] = dLastBlue[node] + 1;
                        }
                        if (!visited[j][0]) {
                            visited[j][0] = true;
                            queue.add(j);
                            lastColor.add(0);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dLastRed[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(dLastBlue[i] + " ");
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dLastRed[i];
            if (ans[i] == -1 || (dLastBlue[i] != -1 &&dLastBlue[i] < ans[i]))
                ans[i] = dLastBlue[i];
        }
        return ans;
    }
}
