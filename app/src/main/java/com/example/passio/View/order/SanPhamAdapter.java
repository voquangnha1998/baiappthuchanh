package com.example.passio.View.order;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.passio.R;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {
    public ArrayList<SanPham> arrayingListener;
    Context mContext;
    public SanPhamAdapter(ArrayList<SanPham> mListenerList, Context context) {
        mContext = context;
        this.arrayingListener = new ArrayList<SanPham>();
        this.arrayingListener =mListenerList;
    }
    public class ViewHolder {
        ImageView mItemPic;
        TextView mLangName,gia;
    }
    @Override
    public int getCount() {
        return arrayingListener.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayingListener.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.dong_order, null);
            holder = new ViewHolder();
            holder.mItemPic = (ImageView) view.findViewById(R.id.img_quan2);
            holder.mLangName=(TextView)view.findViewById(R.id.name1);
            holder.gia=(TextView)view.findViewById(R.id.gia1);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();

        }
        try {
            Bitmap image = arrayingListener.get(position).getImage();
            holder.mItemPic.setImageBitmap(image);
            holder.mLangName.setText(arrayingListener.get(position).getTensp());
            holder.gia.setText(arrayingListener.get(position).getGia()+"");
        }catch (Exception ex){
        }
        return view;
    }

}
