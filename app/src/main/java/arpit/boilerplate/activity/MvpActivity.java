package arpit.boilerplate.activity;

import android.os.Bundle;

import arpit.boilerplate.present.MvpPresenter;
import arpit.boilerplate.view.MvpView;

/**
 * A {@link BaseActivity} that uses an {@link MvpPresenter} to implement a
 * Model-View-Presenter Architecture.
 *
 * @author Hannes Dorfmann
 * @since 1.0.0
 */
public abstract class MvpActivity<P extends MvpPresenter> extends BaseActivity implements MvpView {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }

    /**
     * Instantiate a presenter instance
     *
     * @return The {@link MvpPresenter} for this view
     */
    protected abstract P createPresenter();
}
