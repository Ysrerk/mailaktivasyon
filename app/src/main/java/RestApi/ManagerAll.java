package RestApi;

import Models.Result;
import retrofit2.Call;

public class ManagerAll extends BaseManager {

    public Call<Result> getresult(String kullaniciadi,String email,String sifre){


        Call<Result> resultCall=getrestapi().addmember(kullaniciadi,email,sifre);
        return resultCall;
    }

    public Call<Result>aktiffyap(String email,String kod){
        Call<Result> aktiff=getrestapi().aktifyap(email,kod);
        return aktiff;
    }
}
