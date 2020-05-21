package com.deshaies.nasaimagery.network;

import com.deshaies.nasaimagery.model.NasaResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.deshaies.nasaimagery.util.Constants.URL_POSTFIX;


public interface NasaImageryService {

    @GET(URL_POSTFIX)
    Observable<NasaResult> getNasaResultRx(@Query("sol") String sol_value, @Query("page") String page_value, @Query("api_key") String api_key);
}

/*
https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY

https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=fhaz&api_key=DEMO_KEY

https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=2&api_key=DEMO_KEY
 */
