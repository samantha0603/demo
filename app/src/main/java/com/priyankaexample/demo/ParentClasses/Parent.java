package com.priyankaexample.demo.ParentClasses;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.priyankaexample.demo.R;

public class Parent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        Button syllabus,attendace,timetable,marks,course,notice;
        syllabus = findViewById(R.id.button1);
        attendace = findViewById(R.id.Button04);
        timetable = findViewById(R.id.Button01);
        marks = findViewById(R.id.Button02);
        course = findViewById(R.id.Button03);
        notice = findViewById(R.id.notice);
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.convertopdf.com/?sysid=833&appid=100&subid=130674252222308353&pubid=1987573");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        attendace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ParentAttendance.class);
                startActivity(i);
            }
        });
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ParentTimeTable.class);
                startActivity(i);
            }
        });
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ParentMarks.class);
                startActivity(i);
            }
        });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ParentCourse.class);
                startActivity(i);
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ParentNotice.class);
                startActivity(i);
            }
        });
    }
}
