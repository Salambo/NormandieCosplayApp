package com.normandiecosplay.normandiecosplayapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class CompteARebours extends IntentService {

    public IBinder onBind(Intent intent) {

        return new Liaison();
    }

    public class Liaison extends Binder{
        public int getCompteARebours(){
            return TempsRestant;
        }
    }


    private int TempsRestant;

    public CompteARebours() {
        super("CompteARebours");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        TempsRestant=10;
        while(TempsRestant!=0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TempsRestant=TempsRestant-1;
        }
        Messenger msg = intent.getParcelableExtra("msg");
        try {
            msg.send(Message.obtain(null, 1, "Fini"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }


}
