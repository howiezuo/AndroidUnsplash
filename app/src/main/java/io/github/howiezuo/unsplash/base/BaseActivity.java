package io.github.howiezuo.unsplash.base;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.howiezuo.unsplash.R;
import io.github.howiezuo.unsplash.login.LoginFragment;
import io.github.howiezuo.unsplash.util.ActivityUtils;


public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.fragment_login)
    View mLoginFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
    }

    protected @LayoutRes int getLayoutId() {
        return R.layout.activity_base;
    }

    protected void setHomeIcon(@LayoutRes int layoutId) {
        View v = LayoutInflater.from(this).inflate(layoutId, null);
        v.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());

        v.setDrawingCacheEnabled(true);
        Bitmap bmp = v.getDrawingCache();
        Drawable drawable = new BitmapDrawable(getResources(), bmp);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    protected void showLogin() {
        LoginFragment fragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_login);
        if (fragment == null) {
            fragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.fragment_login);
        }
        mLoginFragment.setVisibility(View.VISIBLE);
    }
}