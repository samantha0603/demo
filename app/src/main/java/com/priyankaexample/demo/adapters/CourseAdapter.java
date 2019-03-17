package com.priyankaexample.demo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.priyankaexample.demo.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    Context context;
    int layout;
    List<CourseData> list;
    public CourseAdapter(List<CourseData> list, int marks_view, Context applicationContext) {
        this.context=applicationContext;
        this.list = list;
        this.layout = marks_view;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.course_student_view,null);


        CourseAdapter.ViewHolder holder = new CourseAdapter.ViewHolder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder viewHolder, int i) {
        viewHolder.subject.setText(list.get(i).getSubject());
        viewHolder.course.setText(list.get(i).getCourse());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,course;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.coursesub);
            course = itemView.findViewById(R.id.courseinfo);
        }
    }
}
