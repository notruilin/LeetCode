class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        Set set = new HashSet();
        for (int x: arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int value: map.values()) {
            if (set.contains(value))    return false;
            set.add(value);
        }
        return true;
    }
}
