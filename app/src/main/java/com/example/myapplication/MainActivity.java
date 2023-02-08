package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
private EditText email;
private EditText theme;
private EditText text;
private MaterialButton send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initListener();

    }

    private void initListener() {
      send.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final Intent intent = new Intent(Intent.ACTION_SEND);
              intent.setType("plain/text");
              intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
              intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
              intent.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
              startActivity(intent);
          }
      });
    }


    private void initView() {
        email = findViewById(R.id.et_Email);
        theme = findViewById(R.id.et_Theme);
        text = findViewById(R.id.et_Text);
        send = findViewById(R.id.bt_Send);

    }


}