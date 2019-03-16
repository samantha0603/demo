package com.priyankaexample.demo.ParentClasses;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

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

public class ParentAttendance extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);


        final PieChart pieChart;


        pieChart=findViewById(R.id.piechart);

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
        int per =random.nextInt(100);
        list.add(new PieEntry(per,"Present"));
        list.add(new PieEntry((100-per),"Absent"));

        PieDataSet dataSet=new PieDataSet(list,"Absenties");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData pieData=new PieData(dataSet);
        pieData.setValueTextSize(10f);
        //pieData.setValueTextColor(Color.YELLOW);
        pieChart.setData(pieData);

    }
}
