package io.github.howiezuo.unsplash.feature.user;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import io.github.howiezuo.unsplash.app.AppApplication;
import io.github.howiezuo.unsplash.R;
import io.github.howiezuo.unsplash.feature.base.BaseActivity;
import io.github.howiezuo.unsplash.model.dto.UserDto;
import io.github.howiezuo.unsplash.feature.user.photos.UserPhotosFragment;
import io.github.howiezuo.unsplash.feature.user.photos.UserPhotosPresenter;
import io.github.howiezuo.unsplash.util.ActivityUtils;
import io.github.howiezuo.unsplash.util.UIUtils;


public class UserActivity extends BaseActivity {

    public static final String EXTRA_USER = "user";

    @Inject
    UserPresenter mUserPresenter;
    @Inject
    UserPhotosPresenter mPhotoPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(UIUtils.view2Drawable(this, R.layout.view_action_back));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (savedInstanceState != null) {
            return;
        }

        UserDto userDto = getIntent().getParcelableExtra(EXTRA_USER);

        UserFragment userFragment = (UserFragment) getSupportFragmentManager().findFragmentById(R.id.container_user);
        if (userFragment == null) {
            userFragment = UserFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), userFragment, R.id.container_user);
        }

        UserPhotosFragment photosFragment = (UserPhotosFragment) getSupportFragmentManager().findFragmentById(R.id.container_photos);
        if (photosFragment == null) {
            photosFragment = UserPhotosFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), photosFragment, R.id.container_photos);
        }

        DaggerUserComponent.builder()
                .apiComponent(AppApplication.getInstance().getApiComponent())
                .helperComponent(AppApplication.getInstance().getHelperComponent())
                .userPresenterModule(new UserPresenterModule(userFragment, photosFragment, userDto))
                .loginPresenterModule(getLoginPresenterModule())
                .build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

}
