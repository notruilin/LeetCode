class Solution {
    private int f(String str) {
        for (char c = 'a'; c <= 'z'; c++) {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == c) {
                    ++count;
                }
            }
            if (count > 0)  return count;
        }
        return 0;
    }
    
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] fwords = new int[words.length];
        for (int i = 0; i < words.length; i++)
            fwords[i] = f(words[i]);
        int[] fqueries = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            fqueries[i] = f(queries[i]);
        int[] ans = new int[queries.length];
        for (int i = 0; i < fqueries.length; i++) {
            for (int j = 0; j < fwords.length; j++) {
                if (fqueries[i] < fwords[j]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
