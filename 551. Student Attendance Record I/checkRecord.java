class Solution {
    public boolean checkRecord(String s) {
        String newS = s.replaceAll("A", "");
        if (s.length() - newS.length() > 1) return false;
        if (s.contains("LLL"))   return false;
        return true;
    }
}
