class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int dis = 0, sum = 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for (int i = start; i < destination; i++)   dis += distance[i];
        for (int i = 0; i < distance.length; i++)   sum += distance[i];
        return Math.min(dis, sum-dis);
    }
}
