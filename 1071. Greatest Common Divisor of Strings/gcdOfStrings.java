class Solution {
    public String gcdOfStrings(String str1, String str2) {
        for (int n = Math.min(str1.length(), str2.length()); n > 0; n--) {
            if (str1.length() % n != 0 || str2.length() % n != 0)   continue;
            boolean f = true;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str1.charAt(i % n)) {
                    f = false;
                    break;
                }
            }
            for (int i = 0; i < str2.length(); i++) {
                if (str2.charAt(i) != str1.charAt(i % n)) {
                    f = false;
                    break;
                }
            }
            if (f)  return str1.substring(0, n);
        }
        return "";
    }
}
