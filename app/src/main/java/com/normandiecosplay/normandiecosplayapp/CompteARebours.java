package com.normandiecosplay.normandiecosplayapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class CompteARebours extends IntentService {
    /*// TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_FOO = "com.normandiecosplay.normandiecosplayapp.action.FOO";
    public static final String ACTION_BAZ = "com.normandiecosplay.normandiecosplayapp.action.BAZ";

    // TODO: Rename parameters
    public static final String EXTRA_PARAM1 = "com.normandiecosplay.normandiecosplayapp.extra.PARAM1";
    public static final String EXTRA_PARAM2 = "com.normandiecosplay.normandiecosplayapp.extra.PARAM2";*/

    private int TempsRestant;

    public CompteARebours() {
        super("CompteARebours");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        TempsRestant=10;
        while(TempsRestant!=1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TempsRestant=TempsRestant-1;
        }
        Messenger msg = intent.getParcelableExtra("msg");
        msg.send(Message.obtain(null, 1, id, 0));
// what=1, arg1=id, arg2=0

        /*if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }*/
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.

    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.

    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
    */
}
