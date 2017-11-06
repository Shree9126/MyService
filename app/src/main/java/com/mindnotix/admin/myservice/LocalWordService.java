package com.mindnotix.admin.myservice;

/**
 * Created by Admin on 5/19/2017.
 */

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class LocalWordService extends Service {
    private final IBinder mBinder = new MyBinder();
    private List<String> resultList = new ArrayList<String>();
    private int counter = 1;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String sss = intent.getStringExtra("adsfadsf");
        Log.v("sssaaaaaaaaaa",""+sss);
        addResultValues();
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {


       addResultValues();
        return mBinder;
    }

    public class MyBinder extends Binder {
        LocalWordService getService() {
            return LocalWordService.this;
        }
    }

    public List<String> getWordList() {
        return resultList;
    }

    private void addResultValues() {
        Random random = new Random();
        List<String> input = Arrays.asList("Linux", "Android","iPhone","Windows7" );
        resultList.add(input.get(random.nextInt(3)) + " " + counter++);
        if (counter == Integer.MAX_VALUE) {
            counter = 0;
        }
    }
}