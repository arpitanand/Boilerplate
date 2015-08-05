package arpit.boilerplate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Base Fragment for other Fragments
 *
 * @author Arpit Anand
 */
public abstract class BaseFragment extends Fragment {

    String TAG = getClass().getSimpleName();
    /**
     * Return the layout resource like R.layout.my_layout
     *
     * @return the layout resource or null, if you don't want to have an UI
     */
    protected abstract int getLayoutRes();

    /**
     * All {@link View#findViewById(int)} goes here
     *
     * @param view The view inflated into the fragment in
     *             {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    protected abstract void findViews(View view);

    /**
     * All the view operations (like Listeners, Adapters, etc.) goes here.
     * Called after {@link #findViews(View)}
     */
    protected abstract void bindViews();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutRes = getLayoutRes();
        if (layoutRes == 0) {
            throw new IllegalArgumentException("getLayoutRes() returned 0, which is not allowed. "
                    + "If you don't want to use getLayoutRes() but implement your own view for this "
                    + "fragment manually, then you have to override onCreateView();");
        } else {
            View v = inflater.inflate(layoutRes, container, false);
            findViews(v);
            bindViews();
            return v;
        }
    }

}
