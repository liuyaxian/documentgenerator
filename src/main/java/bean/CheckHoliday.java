package bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckHoliday {
    private final String[] holiday = new String[]{"2021-06-12", "2021-06-13", "2021-06-14", "2021-09-19", "2021-09-20", "2021-09-21", "2021-10-01", "2021-10-02", "2021-10-03", "2021-10-04", "2021-10-05", "2021-10-06", "2021-10-07"};

    public CheckHoliday() {
    }

    public boolean check() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = fmt.format(today);
        cal.setTime(today);
        boolean check = false;

        for (String s : holiday) {
            if (s.equals(todayStr)){
                return true;
            }
        }
        return  check;


//
//        if (cal.get(7) != 7 && cal.get(7) != 1) {
//            String[] var6 = this.holiday;
//            int var7 = var6.length;
//
//            for(int var8 = 0; var8 < var7; ++var8) {
//                String item = var6[var8];
//                if (item.equals(todayStr)) {
//                    check = true;
//                    break;
//                }
//            }
//
//            return check;
//        } else {
//            return true;
//        }
    }
}
