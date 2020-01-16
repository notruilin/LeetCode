class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = new String();
        for (String str: d) {
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                if (str.charAt(len) == s.charAt(i))  ++len;
                if (len == str.length()) {
                    if (ans.length() < str.length() || (ans.length() == str.length() && str.compareTo(ans) < 0)) {
                        ans = str;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}
