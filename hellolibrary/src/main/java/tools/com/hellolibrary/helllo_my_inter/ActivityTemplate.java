package tools.com.hellolibrary.helllo_my_inter;

/**
 * Created by lenovo on 2016/6/4.
 * 描述：
 */
public interface ActivityTemplate {

    void initData();//初始化Data

    void initView();//初始化View

    void initListener();//初始化控件

    void releaseResource();//是否资源

    void initPresenter();//绑定presenter
}
