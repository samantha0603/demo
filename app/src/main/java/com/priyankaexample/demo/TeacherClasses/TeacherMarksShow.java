package com.priyankaexample.demo.TeacherClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.priyankaexample.demo.R;
import com.priyankaexample.demo.Retrofit.ApiInterface;
import com.priyankaexample.demo.Retrofit.RetroServer;
import com.priyankaexample.demo.adapters.LoginStaticData;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.priyankaexample.demo.ViewPagerAdapter;


public class TeacherMarksShow extends Activity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ProgressBar progressBar;

    RelativeLayout relativeLayout;
    String s;
    TextView textRegNo;
    String API_KEY="AKPhEaFsE8c1f98hiX1VXa0dj5_7KFq0";
    ApiInterface retroGet;
    JSONArray j;
    JSONObject job;
    String st,UNAME;
    List<String> list=new ArrayList<>();
    List<String> listSecond=new ArrayList<>();
    Map<String,JSONObject> map=new LinkedHashMap<>();
    CircleDisplay cd;
    SeekBar seekBar;
    Bitmap bm;
    TextView myText;
    int maxX;
    int imageId;
    ImageView myImage;
    StorageReference childRef,mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_marks_show);

        progressBar = findViewById(R.id.marksprogress);
        relativeLayout = findViewById(R.id.relativemarks);
        textRegNo = findViewById(R.id.textRegNo);
        // bad=v.findViewById(R.id.bad);
        // satisfacotry=v.findViewById(R.id.satisfactory);
        // excellent=v.findViewById(R.id.excellent);
        myImage = findViewById(R.id.myImage);
        Bundle b = getIntent().getExtras();

        try {
            UNAME = b.getString("regNo");
            textRegNo.setText(UNAME);
        } catch (Exception e) {
        }
        seekBar = findViewById(R.id.seekBar);
        myText = findViewById(R.id.myView);
        mStorageRef = FirebaseStorage.getInstance("gs://site-74340.appspot.com").getReference();
        // mStorageRef = FirebaseStorage.getInstance().getReference();

        childRef = mStorageRef.child("Photos/" + UNAME + ".JPG");
        Log.d("imageDisplay", childRef.toString());

        Glide.with(getApplicationContext()).asBitmap().load(childRef).apply(new RequestOptions().transform(new RoundedCorners(40))).listener(new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                Toast.makeText(getApplicationContext(), "Image load failed", Toast.LENGTH_SHORT).show();
                Log.d("imageDisplay", e.toString());

                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource
                    dataSource, boolean isFirstResource) {
                myImage.setImageBitmap(resource);
                return false;
            }
        }).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).submit();

        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        maxX = 50;

        String q = "{\"regno\":{$eq:\"" + LoginStaticData.getRegno() + "\"}}";
        retroGet = RetroServer.getRetrofit().create(ApiInterface.class);
        Call<String> dataCall = retroGet.getMarksData(LoginStaticData.getMarks(), API_KEY, q);
        dataCall.enqueue(new Callback<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.body() != null) {
                    String json = response.body();
                    st = json;

                    try {
                        j = new JSONArray(json);
                        job = j.getJSONObject(0);
                        Iterator<String> it1 = job.keys();
                        Iterator<String> it = job.keys();
                        while (it.hasNext()) {
                            s = it.next();
                        }

                        JSONObject jj = job.getJSONObject(s);
                        JSONObject jj1 = jj.getJSONObject("Final");
                        Iterator<String> itt1 = jj1.keys();
                        Iterator<String> itt2 = jj1.keys();
                        String ss = null;
                        String ss1 = null;
                        boolean b = false;
                        while (itt1.hasNext()) {
                            ss = itt1.next();
                            if (ss.contains("CGPA")) {
                                b = true;
                                break;
                            }

                        }
                        if (!b) {
                            while (itt2.hasNext()) {
                                ss1 = itt2.next();
                                if (ss1.contains("SGPA")) {
                                    ss = ss1;
                                    break;
                                }

                            }
                        }
                        String DE = "%";
                        //  SharedPreferences sharedPreferences=v.getContext().getSharedPreferences("MyLogin",MODE_PRIVATE);
                        // final String UNAME=sharedPreferences.getString("username","");
                        if (Integer.parseInt(LoginStaticData.getRegno().subSequence(0, 2).toString()) > 15) {
                            //cd.showValue(Float.parseFloat(jj1.get(ss).toString()), 100f, false);
                            Float f = Float.parseFloat(jj1.get(ss).toString());
                            // Float floatval=6.4f;
                            myText.setText(f.toString());
                            seekBar.setProgress(Math.round(f));
                            final ViewTreeObserver viewTreeObserver = seekBar.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                                    @Override
                                    public void onGlobalLayout() {
                                        Log.d("wholepositions1", String.valueOf(maxX));
                                        Log.d("wholepositions2", String.valueOf(seekBar.getWidth()));
                                        Log.d("wholepositions3", String.valueOf(seekBar.getThumbOffset()));
                                        int val = (seekBar.getProgress() * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                                        Log.d("wholepositions3", String.valueOf(seekBar.getProgress()));
                                        Log.d("wholepositions4", String.valueOf((seekBar.getWidth() - 2 * seekBar.getThumbOffset())));

                                        int textViewX = val - (myText.getWidth() / 2);
                                        Log.d("wholepositions5", String.valueOf(val));
                                        Log.d("wholepositions6", String.valueOf(textViewX));

                                        int finalX = myText.getWidth() + textViewX > maxX ? (maxX - myText.getWidth()) : textViewX /*your margin*/;
                                        Log.d("wholepositions7", String.valueOf(finalX));
                                        myText.setX(finalX < 0 ? 0/*your margin*/ : finalX);
                                        myText.setTextSize(25);
                                        seekBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    }
                                });
                            }
                            if (f >= 7) {
                                imageId = R.drawable.ic_cool;
                                // excellent.setText(f.toString());
                                // excellent.setBackground(getResources().getDrawable(R.drawable.circle_aggregade_excellent));
                            } else if (f > 6) {
                                imageId = R.drawable.ic_sad;
                                // satisfacotry.setText(f.toString());
                                //  satisfacotry.setBackground(getResources().getDrawable(R.drawable.circle_aggregade_satisfactory));

                            } else {
                                imageId = R.drawable.ic_crying;
                                // bad.setText(f.toString());
                                // bad.setBackground(getResources().getDrawable(R.drawable.circle_aggregade_bad));


                            }
                        } else {
                            Float f = Float.parseFloat(jj1.get("%f").toString());
                            myText.setText(f.toString());
                            seekBar.setProgress(Math.round(f));
                            final ViewTreeObserver viewTreeObserver = seekBar.getViewTreeObserver();
                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                                    @Override
                                    public void onGlobalLayout() {
                                        Log.d("wholepositions1", String.valueOf(maxX));
                                        Log.d("wholepositions2", String.valueOf(seekBar.getWidth()));
                                        Log.d("wholepositions3", String.valueOf(seekBar.getThumbOffset()));
                                        int val = (seekBar.getProgress() * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                                        Log.d("wholepositions3", String.valueOf(seekBar.getProgress()));
                                        Log.d("wholepositions4", String.valueOf((seekBar.getWidth() - 2 * seekBar.getThumbOffset())));

                                        int textViewX = val - (myText.getWidth() / 2);
                                        Log.d("wholepositions5", String.valueOf(val));
                                        Log.d("wholepositions6", String.valueOf(textViewX));

                                        int finalX = myText.getWidth() + textViewX > maxX ? (maxX - myText.getWidth()) : textViewX /*your margin*/;
                                        Log.d("wholepositions7", String.valueOf(finalX));
                                        myText.setX(finalX < 0 ? 0/*your margin*/ : finalX);
                                        myText.setTextSize(25);
                                        seekBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    }
                                });
                            }
                            if (f >= 75) {
                                imageId = R.drawable.ic_cool;
                                //  excellent.setText(f.toString());
                                // excellent.setBackground(getResources().getDrawable(R.drawable.circle_aggregade_excellent));

                            } else if (f > 65) {
                                imageId = R.drawable.ic_crying;
                                /// satisfacotry.setText(f.toString());
                                //  satisfacotry.setBackground(getResources().getDrawable(R.drawable.circle_aggregade_satisfactory));

                            } else {
                                imageId = R.drawable.ic_sad;
                                //  bad.setText(f.toString());
                                // bad.setBackground(getResources().getDrawable(R.drawable.circle_aggregade_bad));

                            }

                        }
                        seekBar.setThumb(getResources().getDrawable(imageId));
                        //  seekBar.setThumb(drawForSeekBar(v.getContext(),R.drawable.thumb_image_ic_cool));
                        while (it1.hasNext()) {
                            list.add(it1.next());

                        }
                        for (String s : list) {
                            try {
                                map.put(s, job.getJSONObject(s));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        map.remove("_id");
                        for (Map.Entry<String, JSONObject> maps : map.entrySet()) {
                            listSecond.add(maps.getValue().toString());
                        }

                        viewPager = findViewById(R.id.viewPager);
                        tabLayout = findViewById(R.id.tabs);
                        viewPager.setOffscreenPageLimit(8);
                        ViewPagerAdapter adapter = new ViewPagerAdapter(getApplicationContext(), map, listSecond);
                        viewPager.setAdapter(adapter);
                        // viewPager.arrowScroll(ViewPager.FOCUS_RIGHT);
                        tabLayout.setupWithViewPager(viewPager);
                        progressBar.setVisibility(View.INVISIBLE);
                        relativeLayout.setVisibility(View.VISIBLE);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                } else {
                    progressBar.setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "please connect to active network", Toast.LENGTH_LONG).show();
            }
        });


    }

}
