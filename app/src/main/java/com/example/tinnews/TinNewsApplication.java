package com.example.tinnews;

import android.app.Application;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;
import com.facebook.stetho.Stetho;

public class TinNewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // debugger using
        Gander.setGanderStorage(GanderIMDB.getInstance());
        // dev tool
        Stetho.initializeWithDefaults(this);
    }
}
