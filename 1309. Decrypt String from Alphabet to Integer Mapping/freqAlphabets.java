class Solution {
    public String freqAlphabets(String s) {
        String ans = new String();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i+2) == '#') {
                ans += (char)('a' + (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0') - 1);
                i += 2;
            }
            else {
                ans += (char)('a' + s.charAt(i) - '0' - 1);
            }
        }
        return ans;
    }
}
