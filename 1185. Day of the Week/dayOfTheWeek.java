import java.time.LocalDate;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate a = LocalDate.of(year, month, day);
        String str = a.getDayOfWeek().name();
        String res = str.charAt(0) + str.toLowerCase().substring(1, str.length());
        return res;
    }
}
