package com.company.enumeratory.zadanie2;

import com.company.enumeratory.zadanie1.Weekend;
import com.company.enumeratory.zadanie1.WorkingDay;

public enum Day implements WorkingDay, Weekend {
    MONDAY("MON",true),
    TUESDAY("TUE",true),
    WEDNESDAY("WED",true),
    THURSDAY("THU",true),
    FRIDAY("FRI",true),
    SATURDAY("SAT",false),
    SUNDAY("SUN",false);


    private String shortcut;

    private boolean isWorkDay;

    Day(String shortcut, boolean isWorkDay) {
        this.shortcut = shortcut;
        this.isWorkDay = isWorkDay;
    }

    @Override
    public boolean isWeekend() {
        return !isWorkDay;
    }

    @Override
    public boolean isWorkingDay() {
        return isWorkDay;
    }

    public String shortWord(){
        return shortcut;
    }
}
