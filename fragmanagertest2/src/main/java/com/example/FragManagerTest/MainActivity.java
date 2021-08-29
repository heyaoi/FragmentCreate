package com.example.FragManagerTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mbtn_1,mbtn_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setListeners();
//        mbtn_1.setOnClickListener(this);
//        mbtn_2.setOnClickListener(this);

        /*mbtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mbtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    private void init(){
        mbtn_1 = findViewById(R.id.btn_fragment1);
        mbtn_2 = findViewById(R.id.btn_fragment2);
    }

    private void setListeners(){
        mbtn_1.setOnClickListener(this);
        mbtn_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fragment1:
                Bundle bundle = new Bundle();
                bundle.putString("message","hello,world");
                FragmentOne fragmentOne = new FragmentOne();
                fragmentOne.setArguments(bundle);

                fragmentOne.setFragmentCallback(new IFragmentCallback() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public String getMsgFromActivity(String msg) {
                        return "hello,I'm from Activity";
                    }
                });


                replaceFragment(fragmentOne);
                break;
            case R.id.btn_fragment2:
                replaceFragment(new FragmentTwo());
                break;
            default:
                /*getLifecycle().addObserver(new MyObserver());
                Log.d(TAG, "replaceFragment: "+getLifecycle().getCurrentState().name());*/
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


}