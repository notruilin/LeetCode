class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> nums = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                nums.add(arr[i]);
                map.put(arr[i], -1);          
            }
        }
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            if (map.get(nums.get(i)) == -1) {
                map.put(nums.get(i), i + 1);
            }
        }
        for (int i = 0; i < arr.length; i++)
            arr[i] = map.get(arr[i]);
        return arr;
    }
}
