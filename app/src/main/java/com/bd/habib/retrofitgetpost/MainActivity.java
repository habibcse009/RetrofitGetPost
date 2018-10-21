package com.bd.habib.retrofitgetpost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView textViewResult;

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextUsername = findViewById(R.id.et_username);
        editTextPassword = findViewById(R.id.et_password);
        textViewResult = findViewById(R.id.tv_result);
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
    }

    public void login(View view) {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        Call<ServerResponse> call = apiInterface.verifyUser(new User(username, password));
        call.enqueue(new Callback<ServerResponse>() {                        //
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse = response.body();
                Toast.makeText(MainActivity.this, serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connection Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getmessage(View view) {
        String username = editTextUsername.getText().toString();
        Call<ServerResponse> call = apiInterface.getMessage(username);
        call.enqueue(new Callback<ServerResponse>() {                        //
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse = response.body();
                Toast.makeText(MainActivity.this, serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connection Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
