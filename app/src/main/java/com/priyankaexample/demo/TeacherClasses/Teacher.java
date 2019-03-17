package com.priyankaexample.demo.TeacherClasses;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.priyankaexample.demo.R;

public class Teacher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Button syllabus,attendance,timetable,marks,notice,course;
        syllabus = findViewById(R.id.button1);
        attendance = findViewById(R.id.Button04);
        timetable = findViewById(R.id.Button01);
        marks = findViewById(R.id.Button02);
        notice = findViewById(R.id.notice_teacher);
        course = findViewById(R.id.button9);
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
                Intent i = new Intent(getApplicationContext(),TeacherAttendance.class);
                startActivity(i);
            }
        });
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TeacherTimes.class);
                startActivity(i);
            }
        });
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Marks.class);
                startActivity(i);
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TeacherNotice.class);
                startActivity(i);
            }
        });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TeacherCourse.class);
                startActivity(i);
            }
        });
    }
}
