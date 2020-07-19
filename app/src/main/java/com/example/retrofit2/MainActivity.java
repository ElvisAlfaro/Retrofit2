package com.example.retrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit2.client.RetrofitClient;
import com.example.retrofit2.entity.Articulo;
import com.example.retrofit2.service.RetrofitApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tvResponse;
    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
        //getArticulo(2);
        getArticulosUserId(3);
    }

    private void initViews() {
        tvResponse = findViewById(R.id.tvResponse);
    }

    private void initValues() {
        apiService = RetrofitClient.getApiService();
    }

    private void getArticulo(int id) {
        apiService.getArticuloId(id).enqueue(new Callback<Articulo>() {
            @Override
            public void onResponse(Call<Articulo> call, Response<Articulo> response) {
                if (response.isSuccessful()) {
                    tvResponse.setText(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Articulo> call, Throwable t) {
                tvResponse.setText(t.getMessage());
            }
        });
    }

    private void getArticulosUserId(int userId) {
        apiService.getArticulosUderId(userId).enqueue(new Callback<List<Articulo>>() {
            @Override
            public void onResponse(Call<List<Articulo>> call, Response<List<Articulo>> response) {
                tvResponse.setText(response.body().size() + "\n\n" + response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<Articulo>> call, Throwable t) {
                tvResponse.setText(t.getMessage());
            }
        });
    }
}
