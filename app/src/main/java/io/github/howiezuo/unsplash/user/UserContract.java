package io.github.howiezuo.unsplash.user;

import io.github.howiezuo.unsplash.base.BasePresenter;
import io.github.howiezuo.unsplash.base.BaseView;

public interface UserContract {

    interface Presenter extends BasePresenter {

        void loadMe();

    }

    interface View extends BaseView<Presenter> {

    }
}
