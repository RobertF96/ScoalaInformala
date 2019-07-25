import java.util.Calendar;
import java.util.Date;

public class UtilDate {


    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date needs to be modified");
        }
        Calendar calendarA = Calendar.getInstance();
        calendarA.setTime(date1);
        Calendar calendarB = Calendar.getInstance();
        calendarB.setTime(date2);
        return isSameDay(calendarA, calendarB);
    }

    public static boolean isSameDay(Calendar calendarA, Calendar calendarB) {
        if (calendarA == null || calendarB == null) {
            throw new IllegalArgumentException("The date needs to be modified");
        }
        return (calendarA.get(Calendar.ERA) == calendarB.get(Calendar.ERA) &&
                calendarA.get(Calendar.YEAR) == calendarB.get(Calendar.YEAR) &&
                calendarA.get(Calendar.DAY_OF_YEAR) == calendarB.get(Calendar.DAY_OF_YEAR));
    }

    public static boolean isToday(Date date) {
        return isSameDay(date, Calendar.getInstance().getTime());
    }

    public static boolean isToday(Calendar calendar) {
        return isSameDay(calendar, Calendar.getInstance());
    }

    public static boolean isBeforeLunch(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR_OF_DAY, 24);
        now.set(Calendar.MINUTE, 00);
        now.set(Calendar.SECOND, 00);
        Calendar givenDate = Calendar.getInstance();
        givenDate.setTime(date);

        return now.before(givenDate);
    }
}