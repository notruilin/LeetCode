class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                ++left;
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
            ++right;
        }
        return ans;
    }
}
