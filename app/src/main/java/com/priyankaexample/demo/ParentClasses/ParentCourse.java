package com.priyankaexample.demo.ParentClasses;

import android.app.Activity;
import android.os.Bundle;

import com.priyankaexample.demo.R;

public class ParentCourse extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_course);
    }
}
