package arpit.boilerplate.fragment;

import android.content.Context;
import android.view.View;

import arpit.boilerplate.present.HomePresenter;
import arpit.boilerplate.view.HomeView;

public class HomeFragment extends MvpFragment<HomePresenter> implements HomeView {

    public HomeFragment() {
    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected void findViews(View view) {

    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
