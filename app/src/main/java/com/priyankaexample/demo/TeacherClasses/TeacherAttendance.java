package com.priyankaexample.demo.TeacherClasses;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.priyankaexample.demo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeacherAttendance extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_attendance);
        final PieChart pieChart;

            final EditText searchname = findViewById(R.id.searchatt);
            final Button btn = findViewById(R.id.searchbtn);

            pieChart=findViewById(R.id.piechart);
            pieChart.setVisibility(View.INVISIBLE);

            pieChart.setUsePercentValues(true);
            pieChart.getDescription().setEnabled(true);
            pieChart.setExtraOffsets(5,10,5,5);
            pieChart.setDragDecelerationFrictionCoef(0.9f);
            pieChart.setTransparentCircleRadius(61f);
            pieChart.setHoleColor(Color.WHITE);
            pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);
            // List<String> s = new ArrayList<>(Arrays.asList("hi", "hello", "wow"));
            List<PieEntry> list=new ArrayList<>();
        Random random=new Random();
        int per =random.nextInt(50)+50;
            list.add(new PieEntry(per,"Present"));
            list.add(new PieEntry((100-per),"Absent"));

            PieDataSet dataSet=new PieDataSet(list,"Absenties");
            dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            PieData pieData=new PieData(dataSet);
            pieData.setValueTextSize(10f);
            //pieData.setValueTextColor(Color.YELLOW);
            pieChart.setData(pieData);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn.setEnabled(false);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    if (searchname.getText().toString().length() < 10){
                        btn.setEnabled(true);
                        Toast.makeText(getApplicationContext(),"Provide a valid registered number",Toast.LENGTH_SHORT).show();
                    }else{
                        pieChart.setVisibility(View.VISIBLE);
                        searchname.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                                btn.setEnabled(true);
                            }
                        });
                    }
                }
            });



    }
}
