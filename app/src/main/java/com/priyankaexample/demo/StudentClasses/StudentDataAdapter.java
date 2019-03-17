package com.priyankaexample.demo.StudentClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.priyankaexample.demo.R;
import com.priyankaexample.demo.adapters.MarksData;

import java.util.List;

public class StudentDataAdapter extends RecyclerView.Adapter<StudentDataAdapter.ViewHolder> {
    Context context;
    int layout;
    List<MarksData> data;
    public StudentDataAdapter(List<MarksData> list, int marks_view, Context applicationContext) {
            this.context=applicationContext;
            this.data = list;
            this.layout = marks_view;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.student_show_marks,null);
        ViewHolder holder = new ViewHolder(v);
        return  holder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.marks.setText(data.get(position).getCgpa());
        String img = data.get(position).getCgpa();
        Double imgmarks = Double.parseDouble(img);
        int intmarks = (int)Math.round(imgmarks);
        holder.seekBar.setProgress(intmarks);
        if(imgmarks > 8){
            holder.reaction.setImageResource(R.drawable.ic_cool);
        }
        else if(imgmarks < 8 && imgmarks > 4){
            holder.reaction.setImageResource(R.drawable.ic_sad);
        }
        else if (imgmarks < 4){
            holder.reaction.setImageResource(R.drawable.ic_sad);
        }

       }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView marks,id,img;
        ImageView reaction;
        SeekBar seekBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            marks=itemView.findViewById(R.id.your_marks);
            reaction= itemView.findViewById(R.id.reactionimg);
            seekBar =itemView.findViewById(R.id.seekBar);
        }
    }
}
