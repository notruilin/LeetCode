class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<Entity> queue = new PriorityQueue();
        int[] countArray = new int[10001];
        for (int value: barcodes)   countArray[value]++;
        for (int i = 1; i <= 10000; i++) {
            if (countArray[i] > 0) {
                queue.add(new Entity(i, countArray[i]));
            }
        }
        int[] ans = new int[barcodes.length];
        int n = 0;
        while (!queue.isEmpty()) {
            Entity top = queue.poll();
            Entity second = queue.poll();
            ans[n++] = top.value;
            if (top.count > 1)  queue.add(new Entity(top.value, top.count - 1));
            if (second != null) {
                ans[n++] = second.value;
                if (second.count > 1)   queue.add(new Entity(second.value, second.count - 1));
            }
        }
        return ans;
    }
}

class Entity implements Comparable<Entity> {
    public int value;
    public int count;
    
    public Entity(int value, int count) {
        this.value = value;
        this.count = count;
    }
    
    @Override
    public int compareTo(Entity other) {
        return -new Integer(this.count).compareTo(new Integer(other.count));
    }
}
