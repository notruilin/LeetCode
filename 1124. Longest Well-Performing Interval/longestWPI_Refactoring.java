import java.util.*;
class Solution {
    public int longestWPI(int[] hours) {
        Hashtable<Integer,Integer> seen = new Hashtable();
        int sum = 0, ans = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0)    ans = i + 1;
            if (seen.containsKey(sum - 1)) {
                ans = Math.max(ans, i - seen.get(sum - 1));
            }
            if (!seen.containsKey(sum)) 
                seen.put(sum, i);
        }
        return ans;
    }
}
