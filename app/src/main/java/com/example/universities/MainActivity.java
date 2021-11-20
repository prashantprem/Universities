package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.paperdb.Book;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Model> universityList;
    private Book savedUniversity;
    private ArrayList<Model> twentyUniv;
    private UniversityAdapter universityAdapter;
    private static final String URL = "http://universities.hipolabs.com/";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);
        initRecyclerView();
        networkRequest();

    }
    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void networkRequest() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Model>> call = api.getAllUniversities();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(response != null)
                {
//                    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedpreferences.edit();
//                    universityList = new ArrayList<>(response.body());
//                    Gson gson = new Gson();
//                    List<Model> list = new ArrayList<Model>();
//                    String jsonText = gson.toJson(list);
//                    editor.putString("key",jsonText);
//                    editor.apply();
                    universityList = new ArrayList<>(response.body());
                    savedUniversity = Paper.book().write("savedUniv",universityList);
                    universityAdapter = new UniversityAdapter(getApplicationContext(),universityList);
                    recyclerView.setAdapter(universityAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
//                Gson gson = new Gson();
//                String jsonText = sharedpreferences.getString("key",null);
//                List<Model> tempList = gson.fromJson(jsonText,List<Model>)
                universityList = Paper.book().read("savedUniv", new ArrayList<>());
                universityAdapter = new UniversityAdapter(getApplicationContext(),universityList);
                recyclerView.setAdapter(universityAdapter);
            }


        });
    }

}