package howiezuo.github.io.unsplash.login;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import howiezuo.github.io.unsplash.Config;
import howiezuo.github.io.unsplash.base.BaseFragment;
import howiezuo.github.io.unsplash.R;

public class LoginFragment extends BaseFragment {

    @BindView(R.id.web_view)
    WebView mWebView;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CookieManager.getInstance().removeAllCookie();
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);

                if (uri.getScheme().equals(Config.APP_SCHEME) && uri.getHost().equals(Config.APP_HOST)) {
                    String code = uri.getQueryParameter("code");
                    return true;
                }
                return false;
            }

        });
        mWebView.loadUrl(Config.LOGIN_URL);
    }
}