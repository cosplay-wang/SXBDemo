package com.sxb.demo.boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FirstReceiver extends BroadcastReceiver {
public final static String TAG = "a.b.c";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");
        if(intent.getAction().equals("a.b.c")){
            Log.e(TAG,intent.getExtras().get("a.b.c").toString());
        }
    }
}
