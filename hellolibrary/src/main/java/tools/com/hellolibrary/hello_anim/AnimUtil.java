package tools.com.hellolibrary.hello_anim;

import android.content.Context;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

import tools.com.hellolibrary.R;


/**
 * Created by lenovo on 2016/6/4.
 * 描述：
 */
public class AnimUtil {
    /*
* @des:当EditText输入不合法提示动画
*/
    public static void showEtErrorAnim(Context ctx,EditText editView, String msg) {
        TranslateAnimation ta = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF, -0.05f,
                TranslateAnimation.RELATIVE_TO_SELF, 0.05f,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0);
        ta.setDuration(300);
        ta.setInterpolator(ctx, R.anim.cycle);
        ta.setRepeatMode(TranslateAnimation.REVERSE);
        editView.startAnimation(ta);
        editView.setHint(msg);
    }
}
