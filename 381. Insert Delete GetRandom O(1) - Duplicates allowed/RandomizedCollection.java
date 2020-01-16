class RandomizedCollection {
    Map<String, Integer> map;
    List<Integer> nums;
    List<Integer> id;
    Map<Integer, Integer> counts;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap();
        nums = new ArrayList();
        id = new ArrayList();
        counts = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = counts.containsKey(val) && counts.get(val) > 0;
        int count = 0;
        if (contain)    count = counts.get(val);
        String key = val + " " + count;
        counts.put(val, counts.getOrDefault(val, 0) + 1);
        map.put(key, nums.size());
        nums.add(val);
        id.add(count);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!counts.containsKey(val) || counts.get(val) == 0)   return false;
        int count = counts.get(val);
        counts.put(val, count - 1);
        int index = map.get(val + " " + (count - 1));
        map.remove(val + " " + (count - 1));
        int last = nums.get(nums.size() - 1);
        map.put(last + " " + id.get(id.size() - 1), index);
        nums.set(index, last);
        id.set(index, id.get(id.size() - 1));
        nums.remove(nums.size() - 1);
        id.remove(id.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
