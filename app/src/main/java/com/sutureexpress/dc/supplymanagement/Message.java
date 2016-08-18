package com.sutureexpress.dc.supplymanagement;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by taylor on 7/20/16.
 */

public class Message {
    public static void message(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
