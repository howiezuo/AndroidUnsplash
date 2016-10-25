package io.github.howiezuo.unsplash.main;

import dagger.Component;
import io.github.howiezuo.unsplash.api.ApiComponent;
import io.github.howiezuo.unsplash.login.LoginPresenterModule;
import io.github.howiezuo.unsplash.util.FragmentScoped;

@FragmentScoped
@Component(
        dependencies = {
                ApiComponent.class
        },
        modules = {
                MainPresenterModule.class,
                LoginPresenterModule.class
        }
)
public interface MainComponent {

    void inject(MainActivity activity);

}
