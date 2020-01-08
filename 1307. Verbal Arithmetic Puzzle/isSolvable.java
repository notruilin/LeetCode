class Solution {
    String[] words;
    String result;
    int[] num = new int[26];
    boolean[] used = new boolean[10];
    Set<Character> set = new HashSet();
    Character [] arr;
    boolean ans = false;
    
    int stringToNum(String str) {
        int x = 0;
        for (int i = 0; i < str.length(); i++) {
            x *= 10;
            x += num[str.charAt(i) - 'A'];
        }
        return x;
    }
    
    void checkResult() {
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            if (num[words[i].charAt(0) - 'A'] == 0)   return;
            sum += stringToNum(words[i]);
        }
        
        int[] tmpNum = new int[26];
        for (int i = 0; i < num.length; i++)
            tmpNum[i] = num[i];
        boolean[] tmpUsed = new boolean[10];
        for (int i = 0; i < used.length; i++)
            tmpUsed[i] = used[i];
        
        for (int i = result.length() - 1; i >= 0; i--) {
            int x = sum % 10;
            sum /= 10;
            if (x == tmpNum[result.charAt(i) - 'A'])    continue;
            else{
                if (tmpNum[result.charAt(i) - 'A'] == -1 && !tmpUsed[x]) {
                    tmpUsed[x] = true;
                    tmpNum[result.charAt(i) - 'A'] = x; 
                }
                else    return;
            }
            if (sum == 0 && i != 0) return;
        }
        
        ans = true;
    }
    
    void dfs(int i) {
        if (i == arr.length) {
            checkResult();
            return;
        }
        if (ans)    return;
        if (num[arr[i] - 'A'] == -1) {
            for (int k = 0; k < 10; k++) {
                if (!used[k]) {
                    num[arr[i] - 'A'] = k;
                    used[k] = true;
                    dfs(i+1);
                    used[k] = false;
                    num[arr[i] - 'A'] = -1;
                }
            }
        }
    }
    
    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;
        for (int i = 0; i < 26; i++)    num[i] = -1;
        for (int i = 0; i < words.length; i++)
            for (int j = 0; j < words[i].length(); j++)
                set.add(words[i].charAt(j));
        arr = new Character[set.size()];
        set.toArray(arr);
        dfs(0);
        return ans;
    }
}
