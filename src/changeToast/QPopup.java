package changeToast;
import android.content.Context;
import android.widget.Toast;
/**
 * Created by DerpPC on 12/24/2014.
 *
 * // just here because I hate Toast. dumb name for a popup message box
 */
public class QPopup extends Toast {
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link android.app.Application}
     *                or {@link android.app.Activity} object.
     */
    public QPopup(Context context)
    {
        super(context);
    }

}
