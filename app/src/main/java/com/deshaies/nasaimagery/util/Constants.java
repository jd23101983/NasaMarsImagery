package com.deshaies.nasaimagery.util;

public class Constants {

    //Error Messages
    static final String TAG = "TAG_X";
    static final String ERROR_PREFIX = "Error: ";
    public static final String RESULTS_NULL = "Results were null";

    //Retrofit call
    public static final String BASE_URL = "https://api.nasa.gov";
    public static final String URL_POSTFIX = "/mars-photos/api/v1/rovers/curiosity/photos?";
    public static final String API_KEY = "DEMO_KEY";
}

/*
https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY

https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=fhaz&api_key=DEMO_KEY

https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=2&api_key=DEMO_KEY
 */
