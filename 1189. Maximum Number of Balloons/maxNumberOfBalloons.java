class Solution {
    public int maxNumberOfBalloons(String text) {
        String str = "balon";
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < text.length(); i++)
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        int ans = 10005;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                if (str.charAt(i) == 'l' || str.charAt(i) == 'o') {
                    ans = Math.min(ans, map.get(str.charAt(i)) / 2);
                }
                else 
                    ans = Math.min(ans, map.get(str.charAt(i)));
            }
            else {
                return 0;
            }
        }
        return ans;
    }
}
