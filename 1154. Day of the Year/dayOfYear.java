class Solution {
    public int dayOfYear(String date) {
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
        String[] dateStrings = date.split("-");
        int year = Integer.parseInt(dateStrings[0]);
        int month = Integer.parseInt(dateStrings[1]);
        int day = Integer.parseInt(dateStrings[2]);
        int ans = 0;
        for (int i = 1; i < month; i++) ans += monthDays[i];
        ans += day;
        if (month > 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0))  ans++;
        return ans;
    }
}
