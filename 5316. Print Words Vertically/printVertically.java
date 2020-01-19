class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String word: words)
            maxLen = Math.max(maxLen, word.length());
        List<String> ans = new ArrayList();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder ver = new StringBuilder();
            for (String word: words) {
                if (word.length() > i) ver.append(word.charAt(i));
                else    ver.append(' ');
            }
            int k = ver.length() - 1;
            while (ver.charAt(k) == ' ') {
                ver.deleteCharAt(k);
                --k;
            }
            ans.add(ver.toString());
        }
        return ans;
    }
}
