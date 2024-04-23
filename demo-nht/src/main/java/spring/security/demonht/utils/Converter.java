package spring.security.demonht.utils;

import spring.security.demonht.entity.RestaurantWorkingTime;
import spring.security.demonht.model.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<DateTime> convertToDateTimeList(List<RestaurantWorkingTime> restaurantWorkingTimes) {
        List<DateTime> dateTimeList = new ArrayList<>();

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        for (RestaurantWorkingTime workingTime : restaurantWorkingTimes) {
            String date = Helper.getDayOfWeek(workingTime.getWeek_day());
            String openTime = timeFormat.format(workingTime.getOpen_hour());
            String closeTime = timeFormat.format(workingTime.getClose_hour());
            String time = openTime + "-" + closeTime;

            DateTime dateTime = new DateTime(date, time);
            dateTimeList.add(dateTime);
        }

        return dateTimeList;
    }
}