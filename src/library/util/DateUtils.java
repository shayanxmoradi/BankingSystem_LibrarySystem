package library.util;

import java.util.Date;

public class DateUtils {
    public static int borrowDateInDays(Date date, int n) {
        Date currentDate = new Date();
        long difference = currentDate.getTime() - date.getTime();
        long daysDifference = difference / (1000 * 60 * 60 * 24);
        return (int) daysDifference;
    }
}