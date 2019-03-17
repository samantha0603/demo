package com.priyankaexample.demo.ParentClasses;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.priyankaexample.demo.LogIns.StudentLogIn;
import com.priyankaexample.demo.R;
import com.priyankaexample.demo.Retrofit.ApiClient;
import com.priyankaexample.demo.Retrofit.ApiInterface;
import com.priyankaexample.demo.StudentClasses.StudentDataAdapter;
import com.priyankaexample.demo.adapters.MarksData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParentShowMarks extends Activity {
    public List<MarksData> list1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_show_marks);
        final RecyclerView recyclerView;
        ProgressBar progressBar ;

        String pr,iss,ds,cn,ca,cp,as;
        String l;
        EditText product_name,Issue,Description_ed,Customer_name,Customer_Phno,Customer_addr;

        ;
        final TextView nocon,nodata;
        final CoordinatorLayout mylayout;



        mylayout=findViewById(R.id.layout);
        recyclerView =findViewById(R.id.homerv2);
        recyclerView.setHasFixedSize(true );
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        nocon=findViewById(R.id.nocon2);
        nodata = findViewById(R.id.nodata2);
        progressBar=new ProgressBar(getApplicationContext());
        //progress bar
        progressBar=findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.VISIBLE);
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (!isConnected){
            progressBar.setVisibility(View.GONE);
            nocon.setVisibility(View.VISIBLE);
        }

        //swiperefresh
        final SharedPreferences sp = getApplicationContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        //final String p = sp.getString("username","error");
        final SwipeRefreshLayout refreshLayout=findViewById(R.id.swipid2);
        final String s = "{\"id\":\"" + StudentLogIn.usr1 + "\"}";

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                if(list1.isEmpty()){
                    nodata.setVisibility(View.VISIBLE);
                }
                if (list1 != null) {
                    nodata.setVisibility(View.INVISIBLE);

                    ApiInterface apiCall = ApiClient.getApiClient().create(ApiInterface.class);
                    Call<List<MarksData>> datacall = apiCall.getMyMarks(s);
                    datacall.enqueue(new Callback<List<MarksData>>() {
                        @Override
                        public void onResponse(Call<List<MarksData>> call, Response<List<MarksData>> response) {
                            list1 = response.body();
                            if(list1.isEmpty()){
                                nodata.setVisibility(View.VISIBLE);
                            }
                            recyclerView.setAdapter(new StudentDataAdapter(list1, R.layout.student_show_marks, getApplicationContext()));


                        }

                        @Override
                        public void onFailure(Call<List<MarksData>> call, Throwable t) {
                            Snackbar snackbar= Snackbar.make(mylayout,"Check Your Connection",Snackbar.LENGTH_SHORT);
                            View mView = snackbar.getView();

                            TextView mTextView =  mView.findViewById(android.support.design.R.id.snackbar_text);

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                                mTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                            else
                                mTextView.setGravity(Gravity.CENTER_HORIZONTAL);

                            snackbar.show();                        }


                    });

                    refreshLayout.setRefreshing(false);
                }
            }
        });
        //Retrofit connection
        ApiInterface apiCall;
        apiCall = ApiClient.getApiClient().create(ApiInterface.class);

        final Call<List<MarksData>> datacall = apiCall.getMyMarks(s);
        final ProgressBar finalProgressBar = progressBar;
        datacall.enqueue(new Callback<List<MarksData>>() {
            @Override
            public void onResponse(Call<List<MarksData>> call, Response<List<MarksData>> response) {
                list1 = response.body();
                if (list1.isEmpty()){
                    nodata.setVisibility(View.VISIBLE);
                }
                if (list1 != null) {

                    finalProgressBar.setVisibility(View.GONE);
                }

                recyclerView.setAdapter(new StudentDataAdapter(list1, R.layout.student_show_marks, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<List<MarksData>> call, Throwable t) {
                Snackbar snackbar= Snackbar.make(mylayout,"Check Your Connection",Snackbar.LENGTH_SHORT);
                View mView = snackbar.getView();

                TextView mTextView =  mView.findViewById(android.support.design.R.id.snackbar_text);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                    mTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                else
                    mTextView.setGravity(Gravity.CENTER_HORIZONTAL);

                snackbar.show();
            }
        });

    }
}
