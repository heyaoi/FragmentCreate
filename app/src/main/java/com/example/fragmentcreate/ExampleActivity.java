package com.example.fragmentcreate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class ExampleActivity extends AppCompatActivity {
    public ExampleActivity() {
        super(R.layout.activity_example);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, ExampleFragment.class, null)
                    .commit();
        }
    }
}