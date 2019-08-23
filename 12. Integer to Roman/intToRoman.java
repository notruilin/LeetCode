class Solution {
    public String intToRoman(int num) {
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        String ans = new String();
        for (int i = values.length - 1; i >= 0; i--) {
            while (num >= values[i]) {
                ans += symbols[i];
                num -= values[i];
            }
        }
        ans = ans.replace("DCCCC", "CM");
        ans = ans.replace("CCCC", "CD");
        ans = ans.replace("LXXXX", "XC");
        ans = ans.replace("XXXX", "XL");
        ans = ans.replace("VIIII", "IX");
        ans = ans.replace("IIII", "IV");
        return ans;
    }
}
