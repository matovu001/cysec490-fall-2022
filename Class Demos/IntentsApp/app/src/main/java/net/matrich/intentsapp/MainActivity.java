package net.matrich.intentsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    EditText mEditTextMessage;
    public static final String EXTRA_MSG = "android.intents.extra.MESSAGE";

    public static final int TEXT_REQUEST = 1;
    private TextView mTextviewReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextMessage = findViewById(R.id.edittext_message);
        mTextviewReply = findViewById(R.id.textview_header_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(TAG, "launchSecondActivity: Button clicked");

        Intent intent = new Intent(this, SecondActivity.class);
        String msg = mEditTextMessage.getText().toString();
        intent.putExtra(EXTRA_MSG, msg);
        //startActivity(intent);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mTextviewReply.setVisibility(View.VISIBLE);
                mTextviewReply.setText(reply);
            }
        }

    }
}