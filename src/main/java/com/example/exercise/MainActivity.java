package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.exercise.anno.FindView;
import com.example.exercise.anno.FindViewUtil;

public class MainActivity extends AppCompatActivity {

    @FindView(R.id.text1)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViewUtil.injectView(this);
        textView.setText("scy");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", "Lance")
                        .putExtra("boy", true)
                        .putExtra("age", 25)
                        .putExtra("money", 600.66);
                startActivity(intent);
            }
        });
    }
}
