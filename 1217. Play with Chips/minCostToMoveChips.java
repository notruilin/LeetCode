class Solution {
    public int minCostToMoveChips(int[] chips) {
        int count = 0;
        for (int i = 0; i < chips.length; i++)
            if (chips[i] % 2 == 0)  ++count;
        return Math.min(count, chips.length-count);
    }
}
