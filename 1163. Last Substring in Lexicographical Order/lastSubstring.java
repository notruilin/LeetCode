class Solution {
    String s;
    
    class SubString {
        int start, end;
        public SubString (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private boolean isLarger(SubString oldS, SubString newS) {
        for (int i = 0; i < Math.min(oldS.end-oldS.start+1, newS.end-newS.start+1); i++) {
            if (s.charAt(oldS.start+i) < s.charAt(newS.start+i)) {
                return true;
            } else {
                if (s.charAt(oldS.start+i) > s.charAt(newS.start+i)) {
                    return false;
                }
            }       
        }
        if (oldS.end-oldS.start+1 < newS.end-newS.start+1)  return true;
        return false;
    }
    
    public String lastSubstring(String s) {
        this.s = s;
        List<SubString> substrings = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i-1) != s.charAt(i)) {
                substrings.add(new SubString(i, s.length()-1));
            }
        }
            
        SubString ans = substrings.get(0);
        for (int i = 1; i < substrings.size(); i++) {
            if (isLarger(ans, substrings.get(i))) {
                ans = substrings.get(i);
            }
        }
        return s.substring(ans.start, ans.end+1);
    }
}
