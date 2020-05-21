package com.deshaies.nasaimagery.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.deshaies.nasaimagery.model.NasaResult;
import com.deshaies.nasaimagery.network.NasaImageryRetrofitInstance;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NasaImageryViewModel extends AndroidViewModel {

    private NasaImageryRetrofitInstance nasaImageryRetrofitInstance;
    private int pageValue;

    public NasaImageryViewModel(@NonNull Application application) {
        super(application);

        nasaImageryRetrofitInstance = new NasaImageryRetrofitInstance();
        pageValue = 0;
    }

    public Observable<NasaResult> getNasaImageryResultRx(String sol_value, String api_key) {
        return  nasaImageryRetrofitInstance
                .getNasaImageryResultRx(sol_value, Integer.toString(++pageValue), api_key)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
