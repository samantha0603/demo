package com.priyankaexample.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ViewPagerAdapter extends PagerAdapter {
    List<String> list=new ArrayList<>();
    List<String> listSecond=new ArrayList<>();

    Map<String,JSONObject> map=new LinkedHashMap<>();
    //String[] keys;
    public  String[] tabs={"SEM 11","SEM 12","SEM 21","SEM 22","SEM 31","SEM 32","SEM 41","SEM 42"};
 public JSONObject job;
 public ViewPagerAdapter(Context fm, Map<String,JSONObject> map, List<String> listSecond){
     this.map=map;
     this.listSecond=listSecond;
     System.out.println("changedbundle"+listSecond);
//     System.out.println("inmap" + job);
//     if (job == null) {
//     } else{
//         Iterator<String> it = job.keys();
//         while (it.hasNext()) {
//             list.add(it.next());
//
//         }
//         for (String s : list) {
//             try {
//                 map.put(s, job.getJSONObject(s));
//             } catch (JSONException e) {
//                 e.printStackTrace();
//             }
//         }
//         map.remove("_id");
//         for (Map.Entry<String, JSONObject> maps : map.entrySet()) {
//             System.out.println("inmap" + maps.getKey() + maps.getValue());
//         }
//     }
 }





    @Override
    public int getCount() {
        return listSecond.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }

    @Override
    public CharSequence getPageTitle(int i)
    {
       return tabs[i];
    }

}
