package com.deshaies.nasaimagery.network;

import com.deshaies.nasaimagery.model.NasaResult;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class NasaService {
    private NasaAPI nasaService;

    public NasaService() {
        NasaImageryRetrofitInstance retrofitInstance = new NasaImageryRetrofitInstance();
        nasaService = createNasaImageryService(retrofitInstance.getRetrofitInstance());
    }
    private NasaAPI createNasaImageryService(Retrofit retrofitInstance) {
        return retrofitInstance.create(NasaAPI.class);
    }

    public Observable<NasaResult> getNasaImageryResultRx(String sol_value, String page_value, String api_key) {
        return nasaService.getNasaResultRx(sol_value, page_value, api_key);
    }
}
