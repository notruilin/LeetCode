class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] count = new int[2001];
        for (int x: A)  count[x]++;
        for (int x = 2000; x >= 1; x--) {
            if (count[x] == 1)  return x;
        }
        return -1;
    }
}
