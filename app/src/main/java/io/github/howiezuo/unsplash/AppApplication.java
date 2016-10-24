package io.github.howiezuo.unsplash;

import android.app.Application;

import io.github.howiezuo.unsplash.api.ApiComponent;
import io.github.howiezuo.unsplash.api.DaggerApiComponent;

public class AppApplication extends Application {

    private static AppApplication sInstance;
    private AppComponent mAppComponent;
    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);

        mApiComponent = DaggerApiComponent.builder()
                .build();
    }

    public static AppApplication getInstance() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}