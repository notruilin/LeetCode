class Solution { 
    public List<Integer> pathInZigZagTree(int label) {
        int depth = 1, curDepNum = 1, totalNum = 1;
        while (totalNum < label) {
            depth++;
            curDepNum *= 2;
            totalNum += curDepNum;
        }
        int start = 0, no = 0;
        List<Integer> ans = new ArrayList();
        ans.add(0, label);
        while (depth > 1) {
            if (depth % 2 != 0) {
                start = totalNum - curDepNum;
                no = (int)Math.ceil((label - (totalNum - curDepNum + 1) + 1) / 2.0);
                ans.add(0, start - no + 1);
            }
            else {
                start = totalNum - curDepNum - curDepNum/2 + 1;
                no = (int)Math.ceil((totalNum - label + 1) / 2.0);
                ans.add(0, start + no - 1);
            }
            totalNum -= curDepNum;
            curDepNum /= 2;
            label = ans.get(0);
            depth -= 1;
        }
        return ans;
    }
}
