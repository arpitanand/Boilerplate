package arpit.boilerplate.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class ViewUtils {

    private static Toast sToast;

    public static void showShortToast(final Context context, final String message) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            toast(context, message, Toast.LENGTH_SHORT);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    toast(context, message, Toast.LENGTH_SHORT);
                }
            });
        }
    }

    public static void showLongToast(final Context context, final String message) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            toast(context, message, Toast.LENGTH_LONG);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    toast(context, message, Toast.LENGTH_LONG);
                }
            });
        }
    }

    private static void toast(Context context, String msg, int length) {
        if (sToast != null) {
            sToast.cancel();
        }
        sToast = Toast.makeText(context, msg, length);
        sToast.show();
    }

}
