package com.priyankaexample.demo.TeacherClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.priyankaexample.demo.R;
import com.priyankaexample.demo.adapters.MarksData;

import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    int layout;
    List<MarksData> data;
    public DataAdapter(List<MarksData> list, int marks_view, Context applicationContext) {
            this.context=applicationContext;
            this.data = list;
            this.layout = marks_view;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.marks_view,null);
        ViewHolder holder = new ViewHolder(v);
        return  holder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.id.setText(data.get(position).getId());
        holder.cgpa.setText(data.get(position).getCgpa());
       }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,id,cgpa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.editname);
            id=itemView.findViewById(R.id.editroll);
            cgpa=itemView.findViewById(R.id.editmarks);
        }
    }
}
