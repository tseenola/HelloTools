package utils.hello_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import helloadapter.CommonViewHolder;

/**
 * Created by lenovo on 2016/10/15.
 * 描述：
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mDatas = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }

    public int getCount() {
        return this.mDatas == null?0:this.mDatas.size();
    }

    public T getItem(int position) {
        return this.mDatas == null?null:this.mDatas.get(position);
    }

    public long getItemId(int position) {
        return (long)position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        CommonViewHolder viewHolder = CommonViewHolder.getCommonViewHolder(this.mContext, convertView, parent, this.mItemLayoutId, position);
        this.convert(viewHolder, this.getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(CommonViewHolder var1, T var2);
}
