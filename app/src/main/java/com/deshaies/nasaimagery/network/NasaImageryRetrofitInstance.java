package com.deshaies.nasaimagery.network;

import com.deshaies.nasaimagery.model.NasaResult;
import com.deshaies.nasaimagery.util.Constants;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NasaImageryRetrofitInstance {

    private NasaImageryService nasaImageryService;
    private OkHttpClient client;

    public NasaImageryRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        nasaImageryService = createNasaImageryService(getRetrofitInstance());
    }

    private Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private NasaImageryService createNasaImageryService(Retrofit retrofitInstance) {
        return retrofitInstance.create(NasaImageryService.class);
    }

    public Observable<NasaResult> getNasaImageryResultRx(String sol_value, String page_value, String api_key) {
        return nasaImageryService.getNasaResultRx(sol_value, page_value, api_key);
    }
}
