package com.priyankaexample.demo.TeacherClasses;

import java.util.ArrayList;
import java.util.List;

public class AttendanceGetter {
    public static List<String> list=new ArrayList<>();

    public static String getA() {
        return a;
    }

    public static void setA(String a) {
        //AttendanceGetter.a = a;
        if(!list.contains(a)) {
            list.add(a);
        }
    }
    public  static  void removeA(String a)
    {
        list.remove(a);
    }

    public static String a;
    public static List<String> getList() {
        return list;
    }



}
