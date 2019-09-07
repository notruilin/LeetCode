class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)   return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean show = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    show = false;
                    break;
                }
            }
            if (show)   return i;
        }
        return -1;
    }
}
