package com.normandiecosplay.normandiecosplayapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Messenger;
import android.util.Log;

/**
 * Created by 21601387 on 22/03/18.
 */

public class Message extends Handler {

    private Messenger mailbox = new Messenger(new Message());

    public void handleMessage(Message msg) {
        Log.d("Bonne annee", "recu " + msg.what + "_" + msg.arg1);
    }

    Intent intent = new Intent(Message.this, TestCompteARebours.class);
    intent.putExtra("msg", mailbox);
    startService(intent);

}
