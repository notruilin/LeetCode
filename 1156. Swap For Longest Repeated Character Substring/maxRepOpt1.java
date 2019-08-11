class Solution {
    public int maxRepOpt1(String text) {
        int ans = 0;
        for (char a = 'a'; a <= 'z'; a++) {
            int left = 0, right = 0, num = 0;
            int leftA = -1, rightA = -1;
            for (int i = 0; i < text.length(); i++)
                if (text.charAt(i) == a) {
                    leftA = i;
                    break;
                }
            for (int i = text.length() - 1; i >= 0; i--)
                if (text.charAt(i) == a) {
                    rightA = i;
                    break;
                }
            if (leftA == -1)    continue;

            if (text.charAt(left) != a) num = 1;
            while (right < text.length() - 1) {
                ++right;
                if (text.charAt(right) != a) ++num;
                if (num > 1) {
                    while (text.charAt(left) == a)  ++left;
                    --num;
                    ++left;
                }
                int curAns = right - left + 1;
                if (leftA >= left && rightA <= right && num == 1)   curAns--;
                ans = Math.max(ans, curAns);
            }
        }
        return ans;
    }
}
