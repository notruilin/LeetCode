class Solution {
    public int removePalindromeSub(String s) {
        if (s.length() == 0)  return 0;
        boolean pali = true;
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                pali = false;
                break;
            }
        if (pali)   return 1;
        return 2;
    }
}
