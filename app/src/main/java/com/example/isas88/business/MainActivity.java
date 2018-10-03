package com.example.isas88.business;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    //create global variables for xml elements
    TextView getDirections;
    TextView phoneCall;
    TextView emailTo;
    TextView website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign elements to the global variables created
        getDirections= findViewById(R.id.directions_txt);
        phoneCall = findViewById(R.id.phone_txt);
        emailTo = findViewById(R.id.email_txt);
        website = findViewById(R.id.website_txt);
    }

    //send email when clicked on email icon/email ID
    public void sndEmail(View V) {
        Intent email_Intent = new Intent();
        Uri email_Uri = Uri.parse("mailto:" + emailTo.getText().toString());
        email_Intent.setAction(Intent.ACTION_SENDTO);
        email_Intent.setData(email_Uri);
        startActivity(email_Intent);
        emailTo.setTextColor(getResources().getColor(R.color.bg_dark));
    }

    //open maps with location when clicked on address/icon
    public void getDirections(View V){
        Uri location_Uri = Uri.parse("geo:0,0?q=" +getDirections.getText().toString());
        //Intent mapIntent_Intent = new Intent(Intent.ACTION_VIEW,location_Uri);
        Intent mapIntent_Intent = new Intent();
        mapIntent_Intent.setAction(Intent.ACTION_VIEW);
        mapIntent_Intent.setData(location_Uri);
        mapIntent_Intent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent_Intent);
        getDirections.setTextColor(getResources().getColor(R.color.bg_dark));
    }

    //open dialer with the number when clicked on icon/phone#
    public void phoneCall(View V){
        Intent phone_Intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phoneCall.getText().toString() ));
        startActivity(phone_Intent);
        phoneCall.setTextColor(getResources().getColor(R.color.bg_dark));
    }

    /*
        sample code to check permission to call when using ACTION_CALL intent
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
               Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                  return;
               }
     */

    //open browser for given URL when clicked on the icon/URL address
    public void openPage(View V){
        Intent webPage_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website.getText().toString()));
        startActivity(webPage_Intent);
        website.setTextColor(getResources().getColor(R.color.bg_dark));
    }

}