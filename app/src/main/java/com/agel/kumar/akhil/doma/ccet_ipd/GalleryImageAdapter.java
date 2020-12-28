package com.agel.kumar.akhil.doma.ccet_ipd;

/**
 * Created by Dell on 04-03-2018.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class GalleryImageAdapter extends BaseAdapter
{
    private Context mContext;



    public GalleryImageAdapter(Context context)
    {
        mContext = context;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup)
    {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);

        i.setImageResource(mImageIds[index]);
        i.setLayoutParams(new Gallery.LayoutParams(300, 300));

        i.setScaleType(ImageView.ScaleType.FIT_XY);




        return i;
    }

    public Integer[] mImageIds = {
            R.drawable.bacolo,
            R.drawable.m,
            R.drawable.n,
            R.drawable.b,
            R.drawable.q,
            R.drawable.w,
            R.drawable.t,
            R.drawable.y,
            R.drawable.u,
            R.drawable.i,
            R.drawable.o,
            R.drawable.p,
            R.drawable.l,
            R.drawable.e,
            R.drawable.r,



            //  R.drawable.two
    };

}