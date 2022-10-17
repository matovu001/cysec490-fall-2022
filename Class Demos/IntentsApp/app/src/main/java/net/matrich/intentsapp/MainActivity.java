package net.matrich.intentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    EditText mEditTextMessage;
    public static final String EXTRA_MSG = "android.intents.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextMessage = findViewById(R.id.edittext_message);
    }

    public void launchSecondActivity(View view) {
        Log.d(TAG, "launchSecondActivity: Button clicked");

        Intent intent = new Intent(this, SecondActivity.class);
        String msg = mEditTextMessage.getText().toString();
        intent.putExtra(EXTRA_MSG, msg);
        startActivity(intent);


    }
}