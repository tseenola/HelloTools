package activity.sale2;

/**
 * Created by lenovo on 2017/4/25.
 * 描述：
 */

public interface OnProcessListener<T> {
    boolean onProcessFinish(T pT);
}
