package activity.sale2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tools.com.hellotools.R;

public class Sale2 extends Activity {


    @Bind(R.id.bt_Sale)
    Button mBtSale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale2);
        ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext, Sale2.class));
    }



    @OnClick(R.id.bt_Sale)
    public void onClick() {
        new SaleProcess(this.getWindow().getDecorView(), this).actionSale();
    }
}
