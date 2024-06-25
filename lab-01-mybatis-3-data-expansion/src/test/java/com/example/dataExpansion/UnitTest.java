package com.example.dataExpansion;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UnitTest {

    @Test
    public void dateTest() throws ParseException {
        int times = 10 * 12;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2003-01-10");

        while (times > 1) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            Date time = calendar.getTime();
            date = time;
            System.out.println(sdf.format(time));

            times--;
        }

    }


}
