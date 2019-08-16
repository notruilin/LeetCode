class MajorityChecker {
    int[] arr;
    List<Integer>[] map = new ArrayList[20001];
    
    public MajorityChecker(int[] arr) {
        this.arr = arr;
        for (int i = 0; i < arr.length; i++) {
            if (map[arr[i]] == null)    map[arr[i]] = new ArrayList();
            map[arr[i]].add(i);
        }
    }
    
    private int biSearch(List<Integer> indexes, int num, boolean bigger) {
        int left = 0, right = indexes.size() - 1;
        while (left < right) {
            int mid = (left+right) / 2;
            if (indexes.get(mid) < num) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (!bigger) {
            if (indexes.get(left) > num)    --left;
        }
        return left;
    }
    
    private int countX(int x, int key1, int key2) {
        int key1Index = biSearch(map[x], key1, true);
        int key2Index = biSearch(map[x], key2, false);
        return key2Index - key1Index + 1;
    }
    
    public int query(int left, int right, int threshold) {
        for (int i = 0; i < 20; i++) {
            Random rand = new Random();
            int index = rand.nextInt(right - left + 1) + left;
            int realCount = countX(arr[index], left, right);
            if (realCount >= threshold)  return arr[index];
        }
        return -1;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
