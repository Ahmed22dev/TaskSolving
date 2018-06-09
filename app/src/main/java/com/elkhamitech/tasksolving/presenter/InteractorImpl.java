package com.elkhamitech.tasksolving.presenter;

import android.content.Context;

import com.elkhamitech.tasksolving.data.FoodAPI;
import com.elkhamitech.tasksolving.data.RetrofitService;
import com.elkhamitech.tasksolving.data.model.FoodResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InteractorImpl implements MainContract.Interactor {


    @Override
    public void getFoodList(final OnFinishedListener onFinishedListener, Context context) {

        /** Create handle for the RetrofitService interface*/
        FoodAPI foodAPI = RetrofitService.getRetrofitInstance(context).create(FoodAPI.class);

        /** Call the method with parameter in the interface to get the data*/

        Call<FoodResponse> call = foodAPI.getFoodData();

        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                onFinishedListener.onFinished(response.body().getFoodList());
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }
}
