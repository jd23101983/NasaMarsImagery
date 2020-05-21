package com.deshaies.nasaimagery.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;

import com.deshaies.nasaimagery.R;
import com.deshaies.nasaimagery.adapter.NasaImageryAdapter;
import com.deshaies.nasaimagery.model.NasaResult;
import com.deshaies.nasaimagery.model.Photo;
import com.deshaies.nasaimagery.util.Constants;
import com.deshaies.nasaimagery.util.DebugLogger;
import com.deshaies.nasaimagery.viewmodel.NasaImageryViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

import static com.deshaies.nasaimagery.util.DebugLogger.logDebug;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.image_results_recycler_view)
    RecyclerView imageResultsRecyclerView;

    private NasaImageryViewModel nasaImageryViewModel;
    private CompositeDisposable compositeDisposable;
    private NasaImageryAdapter nasaImageryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        nasaImageryViewModel = ViewModelProviders.of(this).get(NasaImageryViewModel.class);
        compositeDisposable = new CompositeDisposable();
        setupRecyclerView(new ArrayList<Photo>(0));

        compositeDisposable.add(nasaImageryViewModel.getNasaImageryResultRx(Constants.SOL_VALUE, Constants.API_KEY).subscribe(nasaImageryResult -> {
            displayInformationRx(nasaImageryResult);
        }, throwable -> {
            DebugLogger.logError(throwable);
        }));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                logDebug("************** NASA IMAGERY - SWIPE REFRESH **************");
                refreshImageSet();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void refreshImageSet() {
        compositeDisposable.clear();
        compositeDisposable.add(nasaImageryViewModel.getNasaImageryResultRx(Constants.SOL_VALUE, Constants.API_KEY).subscribe(nasaImageryResult -> {
            displayInformationRx(nasaImageryResult);
        }, throwable -> {
            DebugLogger.logError(throwable);
        }));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    private void displayInformationRx(NasaResult nasaImageryResult) {

        updateRecyclerView(nasaImageryResult.getPhotos());

        for (int i = 0; i < nasaImageryResult.getPhotos().size(); i++) {
            if (nasaImageryResult.getPhotos().get(i) != null) {
                logDebug("Image Source = " + nasaImageryResult.getPhotos().get(i).getImgSrc());
                logDebug("Earth Date = " + nasaImageryResult.getPhotos().get(i).getEarthDate());
                logDebug("Rover Name = " + nasaImageryResult.getPhotos().get(i).getRover().getName());
            }
        }
    }

    private void updateRecyclerView(List<Photo> imageResults) {
        nasaImageryAdapter.updateData(imageResults);
    }

    private void setupRecyclerView(List<Photo> imageResults) {
        nasaImageryAdapter = new NasaImageryAdapter(imageResults);
        imageResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        imageResultsRecyclerView.setAdapter(nasaImageryAdapter);
    }
}
