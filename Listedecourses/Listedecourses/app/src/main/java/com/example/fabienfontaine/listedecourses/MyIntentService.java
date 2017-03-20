package com.example.fabienfontaine.listedecourses;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Binder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import static android.R.attr.id;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public int tempsRestant;

    public MyIntentService() {
        super("name");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
        tempsRestant = 10;
            for (tempsRestant = 10 ; tempsRestant >0 ; tempsRestant--){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    Log.i("temps restant : ",""+tempsRestant);
                    Toast toast = Toast.makeText(getApplicationContext(), "temps restant : "+ ""+tempsRestant, Toast.LENGTH_SHORT);
                    toast.show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.i("FIN", ""+tempsRestant);
            Messenger msg = intent.getParcelableExtra("msg");

            try {
                msg.send(Message.obtain(null, 1, id, 0)); // what=1, arg1=id, arg2=0
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        stopService(intent);
    }

    @Override
    public void onDestroy(){
        Context context = getApplicationContext();
        CharSequence text = "Fin du service !";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private class Liaison extends Binder{
        public int getTempsRestant() {
            return tempsRestant;
        }
    }

}