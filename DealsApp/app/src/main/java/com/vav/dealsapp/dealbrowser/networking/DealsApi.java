package com.vav.dealsapp.dealbrowser.networking;

import com.vav.dealsapp.dealbrowser.model.GetDeals;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Vaibhav on 12/2/2017.
 */

public class DealsApi {
    private static final String API = "deals";
    private static final String CACHING = "Cache-Control: no-cache";

    private static DealsService dealsService=null;

    public static DealsService getDealsApi() {
        if(dealsService==null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append("target");
            stringBuilder.append("-deals.");
            stringBuilder.append("herokuapp.com/api/");
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(stringBuilder.toString())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            dealsService = retrofit.create(DealsService.class);
        }
        return dealsService;
    }

    public interface DealsService {
        @Headers(CACHING)
        @GET(API)
        Call<GetDeals> getDeals();
    }
}
