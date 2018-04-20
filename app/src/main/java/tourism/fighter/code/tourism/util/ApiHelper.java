package tourism.fighter.code.tourism.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dreizehn on 4/18/2018.
 */

public class ApiHelper {
    public static String IP="192.168.1.6";
    public static String ALAMAT(String ip){
        return "http://"+ip+":8000/api/";
    };

    public static Retrofit retroBuilder (String url) {
        Retrofit rf = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return rf;
    }
}
