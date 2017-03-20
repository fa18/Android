package com.example.fabienfontaine.listedecourses;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;

import junit.framework.Test;


/**
 * Created by Hugo on 20/03/2017.
 */

public class RecvMsg extends Handler {

    //Définir un messager
    @Override
    public void handleMessage(Message msg) {
        Log.d("MainActivity", "recu " + msg.what + "_" + "TEST");
    }
}
