package com.theandroiddev.mvplearn5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class SuccessActivity extends AppCompatActivity implements SuccessActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        new SuccessActivityPresenter(this, null);
    }

    @Override
    public void displaySuccesses(List<Success> successList) {

    }

    @Override
    public void displayNoSuccesses() {

    }
}
