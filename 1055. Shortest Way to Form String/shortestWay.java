class Solution {
    public int shortestWay(String source, String target) {
        int j = 0, ans = 0;
        while (j < target.length()) {
            ++ans;
            int lastJ = j;
            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) == target.charAt(j)) {
                    ++j;
                    if (j == target.length()) break;
                }
            }
            if (lastJ == j) return -1;
        }
        return ans;
    }
}
