package com.deshaies.nasaimagery.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.deshaies.nasaimagery.model.NasaResult;
import com.deshaies.nasaimagery.network.NasaImageryRetrofitInstance;
import com.deshaies.nasaimagery.network.NasaService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NasaImageryViewModel extends AndroidViewModel {

    private NasaImageryRetrofitInstance nasaImageryRetrofitInstance;
    private NasaService nasaService;
    private int pageValue;

    public NasaImageryViewModel(@NonNull Application application) {
        super(application);

        nasaService = new NasaService();
        pageValue = 0;
    }

    public Observable<NasaResult> getNasaImageryResultRx(String sol_value, String api_key) {
        return  nasaService
                .getNasaImageryResultRx(sol_value, Integer.toString(++pageValue), api_key)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
