package com.priyankaexample.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.priyankaexample.demo.LogIns.ParentLogIn;
import com.priyankaexample.demo.LogIns.StudentLogIn;
import com.priyankaexample.demo.LogIns.TeacherLogIn;
import com.priyankaexample.demo.ParentClasses.Parent;

public class Welcome extends Activity {
    public static String who;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button b1,b2,b3;

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this,StudentLogIn.class);
                Welcome.who = "student";
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this,StudentLogIn.class);
                Welcome.who = "teacher";
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this,StudentLogIn.class);
                Welcome.who = "parent";
                startActivity(i);
            }
        });

    }
}
