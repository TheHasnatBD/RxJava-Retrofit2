package com.yoloridelondon.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yoloridelondon.myapplication.adapter.TripAdapter;
import com.yoloridelondon.myapplication.model.Trip;
import com.yoloridelondon.myapplication.model.TripHistory;
import com.yoloridelondon.myapplication.services.ItemClickListener;
import com.yoloridelondon.myapplication.services.RetrofitClient;
import com.yoloridelondon.myapplication.services.ServiceAPI;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.hasnat.sweettoast.SweetToast;

public class MainActivity extends AppCompatActivity {

    ServiceAPI serviceAPI;
    List<Trip> tripList = new ArrayList<>();
    RecyclerView recyclerView;
    TextView totalTrips, idTv;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init API
        serviceAPI = RetrofitClient.getClient("https://www.yoloridelondon.com/").create(ServiceAPI.class);

        recyclerView = findViewById(R.id.recyclerView);
        totalTrips = findViewById(R.id.totalTripTv);
        idTv = findViewById(R.id.textView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // get data from server
        getData();

    }

    private void getData() {
        compositeDisposable.add(serviceAPI.getTripHistory("avro.nill.16@gmail.com")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TripHistory>() {
                    @Override
                    public void accept(final TripHistory tripHistory) throws Exception {
                        List<Trip> tripList =  tripHistory.getData();

                        Log.e("tag", "size: "+tripList.size());

                        totalTrips.setText("Total trips: "+tripList.size());
                        idTv.setText("ID: "+ tripHistory.getUserId());

                        //adapter setup
                        TripAdapter adapter = new TripAdapter(tripList, MainActivity.this, new ItemClickListener() {
                            @Override
                            public void onItemClick(View v, int position) {
                                String status = tripHistory.getData().get(position).getStatus();
                                SweetToast.info(MainActivity.this, "Status: "+ status);
                            }
                        });

                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                    }
                })
        );
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
