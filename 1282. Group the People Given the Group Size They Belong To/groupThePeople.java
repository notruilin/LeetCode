class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Integer> groupNo = new HashMap();
        int[] groupNum = new int[501];
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < groupSizes.length; i++) {
            int no = 0;
            if (groupNo.containsKey(groupSizes[i])) {
                no = groupNo.get(groupSizes[i]);
            }
            else {
                groupNo.put(groupSizes[i], ans.size());
                no = ans.size();
                ans.add(new ArrayList<Integer>());
            }
            groupNum[no]++;
            ans.get(no).add(i);
            if (groupNum[no] == groupSizes[i]) {
                groupNum[no] = 0;
                groupNo.remove(groupSizes[i]);
            }
        }
        return ans;
    }
}
