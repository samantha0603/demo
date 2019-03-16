package com.priyankaexample.demo.adapters;

public class LoginStaticData {
    public static String regno;
    public static String marks;
    public static String profile;
    public static String attendance;

    public static String getRegno() {
        return regno;
    }

    public static String getMarks() {
        return marks;
    }

    public static String getProfile() {
        return profile;
    }

    public static String getAttendance() {
        return attendance;
    }

    public static void setRegno(String regno) {
        LoginStaticData.regno = regno;
    }

    public static void setMarks(String marks) {
        LoginStaticData.marks = marks;
    }

    public static void setProfile(String profile) {
        LoginStaticData.profile = profile;
    }

    public static void setAttendance(String attendance) {
        LoginStaticData.attendance = attendance;
    }
}
