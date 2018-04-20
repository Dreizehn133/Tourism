package tourism.fighter.code.tourism.util;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import tourism.fighter.code.tourism.model.Member.Status;

/**
 * Created by Dreizehn on 4/18/2018.
 */

public interface ApiConnection {
    @FormUrlEncoded
    @POST("login")
    Call<Status> loginAkses(
            @Field("email") String username,
            @Field("pass") String password

    );

    @GET("fetch")
    Call<tourism.fighter.code.tourism.model.Tourism.Status> fetchData();
}
