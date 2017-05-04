package roxybakestudio.bakestudio.rest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("baking.json")
    Call<JSONResponse> getMyJSON();
}
