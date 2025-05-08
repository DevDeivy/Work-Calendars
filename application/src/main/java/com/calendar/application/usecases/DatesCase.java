package application.src.main.java.com.calendar.application.usecases;

import java.util.Calendar;
import java.util.Date;

public class DatesCase {
    public static Date getstartSemanaSanta(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19* a + 24) % 30;

        int days = d + (2*b + 4*c +6*d +5) % 7;

        int day = 15 + days;
        int month = 3;
        if (day > 31) {
            day = day - 31;
            day = 4;
        }

        return new Date(year - 1900, month - 1, day);
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date NextMonday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayweek != Calendar.SUNDAY) {
            if (dayweek > Calendar.MONDAY)
                date = addDays(date, 9 - dayweek);
            else
                date = addDays(date, 1);
        }
        return date;
    }
}
