package arpit.boilerplate.view;

import android.content.Context;

public interface BaseMvpView extends MvpView {

    /**
     * Get the activity context to the {@link MvpPresenter}
     */
    Context getContext();
}
