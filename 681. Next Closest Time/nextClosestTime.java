class Solution {
    private boolean isValid(String time, int num) {
        for (int i = 0; i < time.length(); i++)
            if (time.charAt(i) - '0' == num) 
                return true;
        return false;
    }
    
    public String nextClosestTime(String time) {
        int h = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
        int m = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
        int curH = h, curM = m;
        while (true) {
            curM++;
            if (curM == 60) {
                curM = 0;
                curH++;
                if (curH == 24) curH = 0;
            }
            if (isValid(time, curM /10) && isValid(time, curM % 10) && isValid(time, curH / 10) && isValid(time, curH %10)) {
                return "" + curH / 10 + curH % 10 + ":" + curM / 10 + curM % 10;
            }
        }
    }
}
