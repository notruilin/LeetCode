class Solution {
    private List<Character> getString(String str) {
        List<Character> lst = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (lst.size() > 0)
                    lst.remove(lst.size()-1);
            }
            else {
                lst.add(str.charAt(i));
            }
        }
        return lst;
    }
    
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }
}
