package com.abc.demo.ott.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateHelper {

    public static String now()  {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
