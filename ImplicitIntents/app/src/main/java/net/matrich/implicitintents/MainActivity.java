package net.matrich.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mButtonOpenWebsite;
    private EditText mEditTextWebsite;

    private EditText mEditTextLocation;
    private Button mButtonOpenLocation;

    private EditText mEditTextShareText;
    private Button mButtonShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonOpenWebsite = findViewById(R.id.open_website_button);
        mEditTextWebsite = findViewById(R.id.website_edittext);

        mEditTextLocation = findViewById(R.id.location_edittext);
        mButtonOpenLocation = findViewById(R.id.open_location_button);

        mEditTextShareText = findViewById(R.id.share_edittext);
        mButtonShareText = findViewById(R.id.share_text_button);

    }

    public void openWebsite(View view) {
        String url = mEditTextWebsite.getText().toString();
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        Uri webpage = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void openLocation(View view) {

            String location = mEditTextLocation.getText().toString();
            Uri addressUri = Uri.parse("geo:0,0?q=" + location);
            Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
            startActivity(intent);

    }

    public void shareText(View view) {

        String text = mEditTextShareText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share My Text")
                .setText(text)
                .startChooser();

    }
}