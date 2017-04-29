package activity.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import beans.SettingAdapterBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import tools.com.hellolibrary.hello_string.StringUtils;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/4/20.
 * 描述：
 */

public class SettingAty extends Activity implements View.OnClickListener {

    @Bind(R.id.ll_SettingContainer)
    LinearLayout mLlSettingContainer;
    private InputStream lInputStream;
    private List<SettingAdapterBean.SettingBean> mSettingBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_setting);
        ButterKnife.bind(this);


        try {
            lInputStream = this.getAssets().open("SettingConfig");
        } catch (IOException pE) {
            pE.printStackTrace();
        }
        Gson lGson = new Gson();
        SettingAdapterBean lSettingAdapterBean = lGson.fromJson(StringUtils.streamToString(lInputStream), SettingAdapterBean.class);
        mSettingBeanList = lSettingAdapterBean.getSetting();
        for (SettingAdapterBean.SettingBean lSettingBean:mSettingBeanList){
            View lView = View.inflate(this,R.layout.setting_button,null);
            ((TextView)lView.findViewById(R.id.tv_des)).setText(lSettingBean.getName());
            lView.setOnClickListener(this);
            mLlSettingContainer.addView(lView);
        }

    }




    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext,SettingAty.class));
    }

    View mCurrentView = null;
    @Override
    public void onClick(View v) {
        for (int i = 0;i<mLlSettingContainer.getChildCount();i++){
            if (v == mLlSettingContainer.getChildAt(i)){
                mLlSettingContainer.removeAllViews();



                List<SettingAdapterBean.SettingBean.ChildBean> lChildBeanList = mSettingBeanList.get(i).getChild();
                for (SettingAdapterBean.SettingBean.ChildBean lChildBean  :lChildBeanList){
                    View lView = View.inflate(this,R.layout.setting_button,null);
                    ((TextView)lView.findViewById(R.id.tv_des)).setText(lChildBean.getName());
                    lView.setOnClickListener(this);
                    mLlSettingContainer.addView(lView);
                }
                Toast.makeText(this, "i: "+i, Toast.LENGTH_SHORT).show();
            }
        }

    }

 
}
