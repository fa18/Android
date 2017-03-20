package com.example.fabienfontaine.listedecourses;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import java.util.concurrent.TimeUnit;

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
                    Log.i("temps : ",""+tempsRestant);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}