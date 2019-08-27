class Solution {
    List<List<Integer>> ans = new ArrayList();
    Map<Integer, Integer> map = new HashMap();
    ArrayList<HashSet<Pair>> pairs = new ArrayList();
    HashSet<String> added = new HashSet();
    
    void addToMap(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (map.containsKey(a+b)) {
            HashSet<Pair> set = pairs.get(map.get(a+b));
            set.add(new Pair(a, b));
        }
        else {
            map.put(a + b, pairs.size());
            HashSet set = new HashSet<Pair>();
            set.add(new Pair(a, b));
            pairs.add(set);
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)    return ans;
        addToMap(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int x = target - nums[i] - nums[j];
                if (map.containsKey(x)) {
                    HashSet<Pair> set = pairs.get(map.get(x));
                    for (Pair pair: set) {
                        List<Integer> tmp = new ArrayList();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(pair.x);
                        tmp.add(pair.y);
                        Collections.sort(tmp);
                        String str = new String(Integer.toString(tmp.get(0))+","+Integer.toString(tmp.get(1))+","+Integer.toString(tmp.get(2))+","+Integer.toString(tmp.get(3)));
                        if (!added.contains(str)) {
                            added.add(str);
                            ans.add(tmp);
                        }
                    }
                }
            }
            for (int j = 0; j < i; j++) addToMap(nums[i], nums[j]);
        }        
        return ans;
    }
    
    class Pair {
        public int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
