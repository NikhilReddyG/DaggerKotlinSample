package com.test.app.view;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> mTest = new ArrayList<>();
        mTest.add("Test");
        mTest.add("Test 2");
        mTest.add("Test 3");
        for(int i=0;i>mTest.size();i++){
            System.out.println(mTest.get(i));
        }

        for(String test: mTest){
            System.out.println(test);
        }
    }
}
