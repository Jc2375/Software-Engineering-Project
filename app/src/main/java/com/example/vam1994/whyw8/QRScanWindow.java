package com.example.vam1994.whyw8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
//import Activity;

import java.io.Serializable;
//import android.widget.Button;

public class QRScanWindow extends AppCompatActivity implements View.OnClickListener, Serializable {

    //Button btnTakePicture, btnScanBarcode;
    Button btnScanBarcode;
    String tableNumStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_window);

        Intent intentCurrent = getIntent();
        tableNumStr = (String) intentCurrent.getSerializableExtra("tableNumStr");

        initViews();
    }

    private void initViews() {
        //btnTakePicture = (Button) findViewById(R.id.btnTakePicture);
        btnScanBarcode = (Button) findViewById(R.id.btnScanBarcode);
        //btnTakePicture.setOnClickListener(this);
        btnScanBarcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /*case R.id.btnTakePicture:
                Log.d("myTag","Test1");//DELETE
                startActivity(new Intent(QRScanWindow.this, PictureBarcodeActivity.class));
                break;*/
            case R.id.btnScanBarcode:
                Intent intent = new Intent(QRScanWindow.this, ScannedBarcodeActivity.class);
                intent.putExtra("tableNumStr",tableNumStr);
                startActivity(intent);
                break;

        }

    }
}
