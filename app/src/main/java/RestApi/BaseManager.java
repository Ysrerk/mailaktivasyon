package RestApi;

import Models.Result;
import retrofit2.Call;

public class BaseManager {

    public RestApi getrestapi(){

        RestApiClient restApiClient=new RestApiClient(BasuUrl.baseurl);
        return restApiClient.getRestApi();

    }
}
