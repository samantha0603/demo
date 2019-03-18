package com.priyankaexample.demo.ParentClasses;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.priyankaexample.demo.LogIns.StudentLogIn;
import com.priyankaexample.demo.R;

public class Parent extends Activity {
    @Override
    public void onBackPressed(){
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        Button syllabus,attendace,timetable,marks,course,notice,logout;
        syllabus = findViewById(R.id.button1);
        attendace = findViewById(R.id.Button04);
        timetable = findViewById(R.id.Button01);
        marks = findViewById(R.id.Button02);
        course = findViewById(R.id.Button03);
        notice = findViewById(R.id.notice);
        logout = findViewById(R.id.logoutbtn2);
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.jntuk.edu.in/jntuk-dap-b-techb-pharmacy-r16-syllabus-with-b-tech-r16-regulations-reg/");
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
                Intent i = new Intent(getApplicationContext(),ParentShowMarks.class);
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
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StudentLogIn.class));
                finish();
            }
        });
    }
}
