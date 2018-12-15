package com.example.android.dialmein;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private static final int  MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;//TODO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * TEST - This method is called when the Call button is clicked.
     */
    public void dialNumber (View view) {
        EditText numberEditText = findViewById(R.id.phone_number_edit_text);
        String phNumber = numberEditText.getText().toString().trim();
        //TODO remove spl characters from numbers and append number+codes with , and #
        Log.i("DisplayPhoneNumber****", phNumber);
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + Uri.encode(phNumber+",,123#")));
        //intent.setData(Uri.parse("tel:" + phNumber));
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
            //If permission is granted, then start activity here, else user has to click the call button again
            return;
        }
        startActivity(intent);
        //dialPhoneNumber(phNumber);
    }

/*    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + Uri.encode(phNumber+",,123#")));
        //intent.setData(Uri.parse("tel:" + phNumber));
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
            //If permission is granted, then start activity here, else user has to click the call button agai
            return;
        }
        startActivity(intent);

        ///TODO remove this conditional loop based on permission configuration
        //if(intent.resolveActivity(getPackageManager()) != null ) {
           // if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                //ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
           // }
            //else {
                // Permission has already been granted
                Log.i("dialPhoneNumberMethod", "Starting the activity");
                startActivity(intent);
            //}
        //}

    }*/

}
