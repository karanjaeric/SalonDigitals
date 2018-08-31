package com.thepensionapp.salondigitals;

/**
 * Created by ekaranja on 11/26/17.
 */

public  class SalonUtil {
   private  static String url="http://10.0.2.2:8080/SalonApp/";//development url
   // private  static String url="http://178.62.10.52:8080/SalonApp/"; //production url

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        SalonUtil.url = url;
    }
}
