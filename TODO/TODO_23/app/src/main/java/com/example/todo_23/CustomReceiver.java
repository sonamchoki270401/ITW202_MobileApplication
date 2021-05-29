package com.example.todo_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID +".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
//        // TODO: This method is called when the BroadcastReceiver is receiving
//        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");

            if (intentAction != null){
                String toastMessage = "Unknown intent action";
                switch (intentAction){
                    case Intent.ACTION_POWER_CONNECTED:
                        toastMessage = "Power Connected";
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED:
                        toastMessage = "Power disconnected";
                        break;
                    case ACTION_CUSTOM_BROADCAST:
                        toastMessage = "Custom Broadcast Receiver";
                        break;
                }
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
            }

    }

}