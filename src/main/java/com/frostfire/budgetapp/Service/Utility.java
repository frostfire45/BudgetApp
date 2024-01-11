package com.frostfire.budgetapp.Service;

import java.time.LocalDate;

public class Utility {

    public static LocalDate convertStringToDate(String date){
        String year,month,day;
        int yearNum,monthNum,dayNum;

        if(date.contains("/")){
            date = date.replace('/','-');
        }

        String dateSeperation[] = date.split("-");

        if(dateSeperation[0].length() > 2) {
            year = dateSeperation[0].toString();
            month = dateSeperation[1].toString();
            day = dateSeperation[2].toString();
        }
        else {
            year = dateSeperation[2].toString();
            month = dateSeperation[0].toString();
            day = dateSeperation[1].toString();
        }

        yearNum = Integer.parseInt(year);
        monthNum = Integer.parseInt(month);
        dayNum = Integer.parseInt(day);
        LocalDate localDate = LocalDate.of(yearNum,monthNum,dayNum);
        return localDate;
    }

}
