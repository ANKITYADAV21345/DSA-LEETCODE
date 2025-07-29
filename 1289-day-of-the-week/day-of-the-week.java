//codebix
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int[] mon = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daysofweek = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int sum = 0;

        // Add days from full years
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) sum += 366;
            else sum += 365;
        }

        // Add days from months in current year
        for (int i = 1; i < month; i++) {
            sum += mon[i];
            if (i == 2 && isLeapYear(year)) sum += 1; // Adjust for leap year
        }

        sum += day - 1; // Subtract 1 because Jan 1, 1971 is day 0
        return daysofweek[sum % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
