class Solution {
    Set<Integer> set = new HashSet();
    int[][] friends;
    
    void bfs(int id, int level) {
        int[] dis = new int[friends.length];
        boolean[] visited = new boolean[friends.length];
        Queue<Integer> queue = new LinkedList();
        queue.add(id);
        visited[id] = true;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int person: friends[i]) {
                if (!visited[person]) {
                    visited[person] = true;
                    dis[person] = dis[i] + 1;
                    if (dis[person] == level)   set.add(person);
                    else
                        queue.add(person);
                }
            }
        }
    }
    
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        this.friends = friends;
        bfs(id, level);
        HashMap<String, Integer> map = new HashMap();
        for (int person: set) {
            for (String movie: watchedVideos.get(person)) {
                map.put(movie, map.getOrDefault(movie, 0) + 1);
            }
        }
        List<String> movies = new ArrayList<>(map.keySet());
        movies.sort((a, b) -> map.get(a) != map.get(b) ? Integer.compare(map.get(a), map.get(b)) : a.compareTo(b));

        return movies;
    }
}
