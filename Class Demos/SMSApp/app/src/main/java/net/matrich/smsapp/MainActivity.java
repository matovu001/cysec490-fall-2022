package net.matrich.smsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_SEND_SMS = 17;

    EditText mEditTextPhoneNumber;
    EditText mEditTextSMSBody;
    Button mButtonSendSMS;

    String smsNumber;
    String smsBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextPhoneNumber = findViewById(R.id.edittext_phone);
        mEditTextSMSBody = findViewById(R.id.edittext_message);
        mButtonSendSMS = findViewById(R.id.button_sendsms);

    }

    public void sendSMS(View view) {

        smsNumber = mEditTextPhoneNumber.getText().toString();
        smsBody = mEditTextSMSBody.getText().toString();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                                                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

                Toast.makeText(this, "Please grant Send SMS Permission", Toast.LENGTH_LONG).show();

            } else {
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.SEND_SMS },
                        PERMISSIONS_REQUEST_SEND_SMS);
            }

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == PERMISSIONS_REQUEST_SEND_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(smsNumber, null, smsBody, null, null);
                Toast.makeText(this, "SMS Successfully sent", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(this, "Permission Denied.", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}