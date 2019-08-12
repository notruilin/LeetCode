class Solution {
    public boolean isStrobogrammatic(String num) {
        String newNum = new String(num);
        for (int i = 0; i < newNum.length(); i++) {
            switch (newNum.charAt(i)) {
                case '6':
                    newNum = newNum.substring(0,i) + '9' + newNum.substring(i+1);
                    break;
                case '9':
                    newNum = newNum.substring(0,i) + '6' + newNum.substring(i+1);
                    break;
                default:
                    if (newNum.charAt(i) != '0' && newNum.charAt(i) != '1' && newNum.charAt(i) != '8')  return false;
            }
        }
        if (num.equals(new StringBuilder(newNum).reverse().toString()))    return true;
        return false;
    }
}
