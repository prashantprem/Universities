package com.example.universities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private Button mBtn;
    private TextView mName;
    private TextView mState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mName = findViewById(R.id.uName);
        mState = findViewById(R.id.uState);
        mBtn = findViewById(R.id.uBtn);
        Bundle extras = getIntent().getExtras();
        String url = extras.getString("webPage");
        mName.setText(extras.getString("name"));
        mState.setText("State: " + extras.getString("state"));


        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
               startActivity(i);

            }
        });
    }
}