package tools.com.hellotools;

import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellolibrary.hello_spref.SPUtils;

public class MainActivity extends BaseActivity {

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initData() {
        SPUtils.putString(null,"");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {

    }
}
