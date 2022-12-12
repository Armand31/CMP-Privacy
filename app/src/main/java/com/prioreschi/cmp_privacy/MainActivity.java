package com.prioreschi.cmp_privacy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.quantcast.measurement.service.QuantcastClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuantcastClient.activityStart(this, BuildConfig.QUANTCAST_API_KEY, null, null);

        //QuantcastClient.showQuantcastPrivacyPolicy(this); //-> Redirects to QC Privacy Policy online
        defineListeners();
    }

    private void defineListeners() {

        Button optOut = findViewById(R.id.opt_out_button);
        optOut.setOnClickListener(view -> QuantcastClient.showAboutQuantcastScreen(MainActivity.this));
    }

    @Override
    public void onStop() {
        super.onStop();
        QuantcastClient.activityStop();
    }
}