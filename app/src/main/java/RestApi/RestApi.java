package RestApi;

import Models.Result;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {

    @FormUrlEncoded
    @POST("/mailolustur.php")
    Call<Result>addmember(@Field("kullaniciadi") String kullaniciadi,@Field("email") String email,@Field("sifre") String sifre);

    @GET("aktifyap.php")
    Call<Result>aktifyap(@Query("email") String email,@Query("kod") String kod);
}
