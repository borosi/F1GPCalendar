package com.example.mobsoft.f1gpcalendar.utils;

import android.os.Looper;

import java.util.concurrent.Executor;
import android.os.Handler;
import android.support.annotation.NonNull;

public class UiExecutor implements Executor {

    private Handler handler;

    public UiExecutor() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(@NonNull Runnable command) {
        handler.post(command);
    }
}
