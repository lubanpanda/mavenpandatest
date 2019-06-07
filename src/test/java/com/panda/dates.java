package com.panda;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dates {
    public static void main(String[] args) {
        Date now = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft.format(now));
        System.out.println("Current Date: " + now.toString());
    }

}
