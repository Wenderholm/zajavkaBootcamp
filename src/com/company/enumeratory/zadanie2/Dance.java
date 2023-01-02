package com.company.enumeratory.zadanie2;

import java.awt.*;
import java.util.Arrays;

public enum Dance {

    HIPHOP(new String[]{"18:20" , "19:30"}, new Day[]{Day.MONDAY, Day.SATURDAY}){
        @Override
        public Dance alternativeData() {
            return MODERNDANCE;
        }
    },
    POP(new String[]{"15:20" , "16:30"}, new Day[]{Day.SUNDAY, Day.TUESDAY}){
        @Override
        public Dance alternativeData() {
            return HIPHOP;
        }
    },
    KAPUEIRA(new String[]{"10:10" , "13:10"}, new Day[]{Day.WEDNESDAY, Day.FRIDAY}){
        @Override
        public Dance alternativeData() {
            return POP;
        }
    },
    MODERNDANCE(new String[]{"10:20" , "11:30"}, new Day[]{Day.MONDAY, Day.SATURDAY}){
        @Override
        public Dance alternativeData() {
            return KAPUEIRA;
        }
    };


    private final String[] lessonTime;

    private final Day[] lessonDay;

    Dance(String[] lessonTime, Day[] lessonDay) {
        this.lessonTime = lessonTime;
        this.lessonDay = lessonDay;
    }

    public abstract Dance alternativeData();

    public String getHours(){
        return Arrays.toString(lessonTime);
    }

    public String getDay(){
        return Arrays.toString(lessonDay);
    }
}
