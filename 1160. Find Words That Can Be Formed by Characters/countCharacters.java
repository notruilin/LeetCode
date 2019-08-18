class Solution {
    public int countCharacters(String[] words, String chars) {
        int count[] = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            count[chars.charAt(i)-'a']++;
        }
        int ans = 0;
        for (String word: words) {
            int c[] = new int[26];
            for (int i = 0; i < 26; i++)
                c[i] = count[i];
            boolean can = true;
            for (int i = 0; i < word.length(); i++) {
                c[word.charAt(i)-'a']--;
                if (c[word.charAt(i)-'a'] < 0) {
                    can = false;
                    break;
                }
            }
            if (can)    ans += word.length();
        }
        return ans;
    }
}
