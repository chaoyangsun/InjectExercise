package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.exercise.anno.Autowired;
import com.example.exercise.anno.AutowiredUtils;
import com.example.exercise.anno.AutowiredUtils2;
import com.example.exercise.anno.FindView;
import com.example.exercise.anno.FindViewUtil;

public class SecondActivity extends AppCompatActivity {
    @Autowired
    public String name;
    @Autowired("boy")
    public boolean isBoy;
    @Autowired("age")
    public int age;
    @Autowired
    private Double money;
    @FindView(R.id.text1)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        AutowiredUtils2.inject(this);
        FindViewUtil.injectView(this);
        textView.setText(name + " - " + isBoy + " - " + age + " - " + money);
    }
}
