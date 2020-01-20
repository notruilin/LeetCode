class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        int count = stones.length;
        while (count > 1) {
            int xIndex = -1, yIndex = -1;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] == -1)    continue;
                if (yIndex == -1 || stones[yIndex] <= stones[i]) {
                    xIndex = yIndex;
                    yIndex = i;
                }
                else {
                    if (xIndex == -1 || stones[xIndex] <= stones[i])
                        xIndex = i;
                }
            }
            if (stones[xIndex] == stones[yIndex]) {
                stones[xIndex] = -1;
                stones[yIndex] = -1;
                count -= 2;
            }
            else {
                stones[yIndex] -= stones[xIndex];
                stones[xIndex] = -1;
                count--;
            }
        }
        int ans = 0;
        for (int x: stones)
            if (x != -1)    ans = x;
        return ans;
    }
}
