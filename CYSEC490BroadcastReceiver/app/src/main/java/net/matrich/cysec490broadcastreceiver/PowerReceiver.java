package net.matrich.cysec490broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String intentAction = intent.getAction();

        if (intentAction != null) {
            String message = "";
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    message = "Power connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    message = "Power disconnected";
                    break;
                default:
                    message = "Unknown broadcast recieved";
            }

            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }

    }
}