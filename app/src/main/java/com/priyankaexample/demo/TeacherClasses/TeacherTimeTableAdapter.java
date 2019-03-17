package com.priyankaexample.demo.TeacherClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.priyankaexample.demo.R;

import java.util.List;
import com.priyankaexample.demo.adapters.TeacherTimeTable;

public class TeacherTimeTableAdapter extends RecyclerView.Adapter<TeacherTimeTableAdapter.ViewHolder> {
    Context c;
    List<TeacherTimeTable> list;
    int lay;
    public TeacherTimeTableAdapter(List<TeacherTimeTable> list, int time_table, Context applicationContext) {
        this.list =list;
        this.c = applicationContext;
        this.lay = time_table;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View v = layoutInflater.inflate(R.layout.time_table,null);
        ViewHolder holder = new ViewHolder(v);
        return  holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.t11.setText(list.get(i).getT11());
        viewHolder.t12.setText(list.get(i).getT12());
        viewHolder.t13.setText(list.get(i).getT13());
        viewHolder.t14.setText(list.get(i).getT14());
        viewHolder.t15.setText(list.get(i).getT15());
        viewHolder.t16.setText(list.get(i).getT16());
        viewHolder.t17.setText(list.get(i).getT17());

        viewHolder.t21.setText(list.get(i).getT21());
        viewHolder.t22.setText(list.get(i).getT22());
        viewHolder.t23.setText(list.get(i).getT23());
        viewHolder.t24.setText(list.get(i).getT24());
        viewHolder.t25.setText(list.get(i).getT25());
        viewHolder.t26.setText(list.get(i).getT26());
        viewHolder.t27.setText(list.get(i).getT27());

        viewHolder.t31.setText(list.get(i).getT31());
        viewHolder.t32.setText(list.get(i).getT32());
        viewHolder.t33.setText(list.get(i).getT33());
        viewHolder.t34.setText(list.get(i).getT34());
        viewHolder.t35.setText(list.get(i).getT35());
        viewHolder.t36.setText(list.get(i).getT36());
        viewHolder.t37.setText(list.get(i).getT37());

        viewHolder.t41.setText(list.get(i).getT41());
        viewHolder.t42.setText(list.get(i).getT42());
        viewHolder.t43.setText(list.get(i).getT43());
        viewHolder.t44.setText(list.get(i).getT44());
        viewHolder.t45.setText(list.get(i).getT45());
        viewHolder.t46.setText(list.get(i).getT46());
        viewHolder.t47.setText(list.get(i).getT47());

        viewHolder.t51.setText(list.get(i).getT51());
        viewHolder.t52.setText(list.get(i).getT52());
        viewHolder.t53.setText(list.get(i).getT53());
        viewHolder.t54.setText(list.get(i).getT54());
        viewHolder.t55.setText(list.get(i).getT55());
        viewHolder.t56.setText(list.get(i).getT56());
        viewHolder.t57.setText(list.get(i).getT57());

        viewHolder.t61.setText(list.get(i).getT61());
        viewHolder.t62.setText(list.get(i).getT62());
        viewHolder.t63.setText(list.get(i).getT63());
        viewHolder.t64.setText(list.get(i).getT64());
        viewHolder.t65.setText(list.get(i).getT65());
        viewHolder.t66.setText(list.get(i).getT66());
        viewHolder.t67.setText(list.get(i).getT67());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t11,t12,t13,t14,t15,t16,t17;
        TextView t21,t22,t23,t24,t25,t26,t27;
        TextView t31,t32,t33,t34,t35,t36,t37;
        TextView t41,t42,t43,t44,t45,t46,t47;
        TextView t51,t52,t53,t54,t55,t56,t57;
        TextView t61,t62,t63,t64,t65,t66,t67;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t11 = itemView.findViewById(R.id.tt11);
            t12 = itemView.findViewById(R.id.tt12);
            t13 = itemView.findViewById(R.id.tt13);
            t14 = itemView.findViewById(R.id.tt14);
            t15 = itemView.findViewById(R.id.tt15);
            t16 = itemView.findViewById(R.id.tt16);
            t17 = itemView.findViewById(R.id.tt17);
            t21 = itemView.findViewById(R.id.tt21);
            t22 = itemView.findViewById(R.id.tt22);
            t23 = itemView.findViewById(R.id.tt23);
            t24 = itemView.findViewById(R.id.tt24);
            t25 = itemView.findViewById(R.id.tt25);
            t26 = itemView.findViewById(R.id.tt26);
            t27 = itemView.findViewById(R.id.tt27);
            t31 = itemView.findViewById(R.id.tt31);
            t32 = itemView.findViewById(R.id.tt32);
            t33 = itemView.findViewById(R.id.tt33);
            t34 = itemView.findViewById(R.id.tt34);
            t35 = itemView.findViewById(R.id.tt35);
            t36 = itemView.findViewById(R.id.tt36);
            t37 = itemView.findViewById(R.id.tt37);
            t41 = itemView.findViewById(R.id.tt41);
            t42 = itemView.findViewById(R.id.tt42);
            t43 = itemView.findViewById(R.id.tt43);
            t44 = itemView.findViewById(R.id.tt44);
            t45 = itemView.findViewById(R.id.tt45);
            t46 = itemView.findViewById(R.id.tt46);
            t47 = itemView.findViewById(R.id.tt47);
            t51 = itemView.findViewById(R.id.tt51);
            t52 = itemView.findViewById(R.id.tt52);
            t53 = itemView.findViewById(R.id.tt53);
            t54 = itemView.findViewById(R.id.tt54);
            t55 = itemView.findViewById(R.id.tt55);
            t56 = itemView.findViewById(R.id.tt56);
            t57 = itemView.findViewById(R.id.tt57);
            t61 = itemView.findViewById(R.id.tt61);
            t62 = itemView.findViewById(R.id.tt62);
            t63 = itemView.findViewById(R.id.tt63);
            t64 = itemView.findViewById(R.id.tt64);
            t65 = itemView.findViewById(R.id.tt65);
            t66 = itemView.findViewById(R.id.tt66);
            t67 = itemView.findViewById(R.id.tt67);

        }
    }
}
