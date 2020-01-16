class RandomizedSet {
    List<Integer> lst;
    Map<Integer, Integer> map;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        lst = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))   return false;
        map.put(val, lst.size());
        lst.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))  return false;
        int last = lst.get(lst.size() - 1);
        lst.set(map.get(val), last);
        lst.remove(lst.size() - 1);
        map.put(last, map.get(val));
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(lst.size());
        return lst.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
