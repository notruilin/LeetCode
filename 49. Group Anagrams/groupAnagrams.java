class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap();
        List<List<String>> ans = new ArrayList();
        int id = 0;
        for (String str: strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                while (count[i] > 0) {
                    count[i]--;
                    sb.append((char)(i + 'a'));
                }
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, id++);
                ans.add(new ArrayList());
            }
            ans.get(map.get(key)).add(str);
        }
        return ans;
    }
}
