package com.padc.aml.attractioninmyanmar.utils;

import com.google.gson.Gson;

/**
 * Created by user on 7/9/2016.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
