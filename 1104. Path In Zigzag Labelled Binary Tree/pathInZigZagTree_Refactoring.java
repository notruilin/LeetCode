class Solution { 
    public List<Integer> pathInZigZagTree(int label) {
        int depth = 1;
        while ((1 << depth) - 1 < label)  ++depth;
        List<Integer> ans = new ArrayList();
        ans.add(0, label);
        while (depth > 1) {
            if (depth % 2 == 0) {
                label = (1 << depth) - 1 - (1 << (depth - 1)) + 1 + (1 << depth) - 1 - label;
            }
            --depth;
            if (label % 2 != 0) label--;
            label /= 2;
            if (depth % 2 == 0) {
                label = (1 << depth) - 1 - (1 << (depth - 1)) + 1 + (1 << depth) - 1 - label;
            }
            ans.add(0, label);
        }
        return ans;
    }
}
