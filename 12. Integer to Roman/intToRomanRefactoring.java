class Solution {
    public String intToRoman(int num) {
        int[] val = {1000, 500, 100, 50, 10, 5, 1};
        char[] ch = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        String ans = new String();
        for (int i = 0; i < ch.length; i++) {
            while (num >= val[i]) {
                ans += ch[i];
                num -= val[i];
            }
            if (i < val.length - 1 && num >= val[i] - val[i+2-i%2]) {
                ans += ch[i+2-i%2];
                ans += ch[i];
                num -= val[i] - val[i+2-i%2];
            }
        }
        return ans;
    }
}
