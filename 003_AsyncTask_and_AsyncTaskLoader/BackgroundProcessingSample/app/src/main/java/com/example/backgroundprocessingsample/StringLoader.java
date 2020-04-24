package com.example.backgroundprocessingsample;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

public class StringLoader extends AsyncTaskLoader {

    private final String mUrl;

    public StringLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Override
    public String loadInBackground() {
        Log.i(StringLoader.class.getSimpleName(), "loadInBackground()");
        final String text = InternetUtils.downloadFile(mUrl);
        return text;
    }
}
