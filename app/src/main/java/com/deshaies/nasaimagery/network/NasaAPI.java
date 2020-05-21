package com.deshaies.nasaimagery.network;

import com.deshaies.nasaimagery.model.NasaResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.deshaies.nasaimagery.util.Constants.URL_POSTFIX;

public interface NasaAPI {

    @GET(URL_POSTFIX)
    Observable<NasaResult> getNasaResultRx(@Query("sol") String sol_value, @Query("page") String page_value, @Query("api_key") String api_key);
}
