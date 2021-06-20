package com.smu.camping.util;

import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;

@Repository
public class CalendarUtil {
    public static int calculateDateDiff(Date startDate, Date endDate){
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate); //금일 날짜

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate); //특정 일자

        long diffSec = (startCal.getTimeInMillis() - endCal.getTimeInMillis()) / 1000;
        int diffDays = (int)(diffSec / (24*60*60)); //일자수 차이

        return diffDays;
    }
}
