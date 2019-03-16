package com.priyankaexample.demo.StudentClasses;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.priyankaexample.demo.R;

public class Student extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Button syllabus,attendance,timetable,marks,course,notice;
        syllabus = findViewById(R.id.button4);
        attendance = findViewById(R.id.button2);
        timetable = findViewById(R.id.button3);
        marks = findViewById(R.id.button5);
        course = findViewById(R.id.button1);
        notice = findViewById(R.id.notice_student);
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.convertopdf.com/?sysid=833&appid=100&subid=130674252222308353&pubid=1987573");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudentAttendance.class);
                startActivity(i);
            }
        });
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudentTimeTable.class);
                startActivity(i);
            }
        });
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudentMarks.class);
                startActivity(i);
            }
        });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudentCourse.class);
                startActivity(i);
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StudentNotice.class);
                startActivity(i);
            }
        });
    }
}
