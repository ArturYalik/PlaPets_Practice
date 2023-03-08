package helpers;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataHelper {

    public static String randomNumeric(int strLen) {
        String numStr = "";
        Random random = new Random();
        int i1 = random.nextInt(9) + 1;
        numStr += i1;

        for (int i = 0; i < strLen - 1; i++) {
            int num = random.nextInt(10);
            numStr += num;
        }

        return numStr;
    }

    public static String randomNumberInGivenRange(int min, int max){
        max -= min;
        int n = (int) ((Math.random() * ++max) + min);
        String number = Integer.toString(n);
        return number;
    }

    public static String getCurrentTimeFormat(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getCurrentDateTimeFormat(String format) {
        //        Format example "yyyy-MM-dd" or "MM/dd/yyyy h:mm a"
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getCurrentDate() {
        String today;
        Date date;
        Format formatter;
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        today = formatter.format(date);
        return today;
    }

    public static String getYesterdayDate() {
        String yesterday;
        Date date;
        Format formatter;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        yesterday = formatter.format(date);
        return yesterday;
    }

    public static String getTomorrowDate() {
        String tomorrow;
        Date date;
        Format formatter;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        tomorrow = formatter.format(date);
        return tomorrow;
    }

    public static String generateEmail(int len) {
        return "test_" + randomNumeric(len) + "@gmail.com";
    }

    public static Object getRandomFromArray(Object[] array) {
        int n = (int) Math.floor(Math.random() * array.length);
        return array[n];
    }

    public static String getRandomFromArrayList(List<String> list) {
        int n = (int) Math.floor(Math.random() * list.size());
        return list.get(n);
    }

}
