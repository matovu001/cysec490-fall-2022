package edu.gannon.hellotoastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int mCount = 0;
    private TextView mTextViewShowCount;
    private Button mButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewShowCount = (TextView)findViewById(R.id.show_count);
        mButtonCount = (Button)findViewById(R.id.button_count);

        mButtonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                if (mTextViewShowCount != null)
                    mTextViewShowCount.setText(Integer.toString(mCount));
            }
        });
    }

    public void showToast(View view) {
        Toast toastMsg = Toast.makeText(this, "My application!", Toast.LENGTH_LONG);
        toastMsg.show();
    }

}