package com.smis935820.parcial_pcii.remote;

import com.smis935820.parcial_pcii.interfaces.paisAPI;

public class APIUtils {
    public APIUtils() {
    }

    public static final String API_URL ="http://127.0.0.1/"; //Cambiar esta URL por la de nuestro equipo

    public static paisAPI getAPI(){
        return RetrofitClient.getClient(API_URL).create(paisAPI.class);
    }
}
