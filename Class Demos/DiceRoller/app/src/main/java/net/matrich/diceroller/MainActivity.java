package net.matrich.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImageViewDice;
    TextView mTextVewDisplay;
    Button mButtonRoll;
    int rollResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewDice = findViewById(R.id.imageView_dice);
        mTextVewDisplay = findViewById(R.id.textView_display);
        mButtonRoll = findViewById(R.id.button_roll);

        mButtonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rollDice();

                Toast msg = Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_LONG);
                msg.show();
            }
        });
    }

    private void rollDice() {
        rollResult = new Random().nextInt(6) + 1;
        mTextVewDisplay.setText(String.valueOf(rollResult));

        switch (rollResult) {
            case 1:
                mImageViewDice.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                mImageViewDice.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                mImageViewDice.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                mImageViewDice.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                mImageViewDice.setImageResource(R.drawable.dice_5);
                break;
            default:
                mImageViewDice.setImageResource(R.drawable.dice_6);
                break;

        }
    }
}