package howiezuo.github.io.unsplash.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import howiezuo.github.io.unsplash.R;
import howiezuo.github.io.unsplash.login.LoginFragment;
import howiezuo.github.io.unsplash.util.ActivityUtils;


public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.fragment_login)
    View mLoginFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected @LayoutRes int getLayoutId() {
        return R.layout.activity_base;
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