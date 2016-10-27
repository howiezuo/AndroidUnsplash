package io.github.howiezuo.unsplash;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import io.github.howiezuo.unsplash.helper.HelperComponent;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(Context context);

    HelperComponent.Builder helperComponent();

}
