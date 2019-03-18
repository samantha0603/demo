package com.priyankaexample.demo.TeacherClasses;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.priyankaexample.demo.LogIns.StudentLogIn;
import com.priyankaexample.demo.R;

public class Teacher extends Activity {
    @Override
    public void onBackPressed(){
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Button syllabus,attendance,timetable,marks,notice,course,logout;
        syllabus = findViewById(R.id.button1);
        attendance = findViewById(R.id.Button04);
        timetable = findViewById(R.id.Button01);
        marks = findViewById(R.id.Button02);
        notice = findViewById(R.id.notice_teacher);
        course = findViewById(R.id.button9);
        logout = findViewById(R.id.logoutbtn);
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.jntuk.edu.in/jntuk-dap-b-techb-pharmacy-r16-syllabus-with-b-tech-r16-regulations-reg/");
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
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StudentLogIn.class));
                finish();
            }
        });

    }
}
