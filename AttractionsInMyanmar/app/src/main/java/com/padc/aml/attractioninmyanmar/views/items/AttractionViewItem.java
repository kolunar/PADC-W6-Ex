package com.padc.aml.attractioninmyanmar.views.items;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.data.vos.AttractionVO;

/**
 * Created by user on 7/9/2016.
 */
public class AttractionViewItem extends CardView {

    private TextView tvAttractionTitle;
    private ImageView ivStockPhoto;
    private TextView tvAttractionDesc;

    public AttractionViewItem(Context context) {
        super(context);
    }

    public AttractionViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AttractionViewItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvAttractionTitle = (TextView) findViewById(R.id.tv_attraction_title);
        ivStockPhoto = (ImageView) findViewById(R.id.iv_stock_photo);
        tvAttractionDesc = (TextView) findViewById(R.id.tv_attraction_desc);
    }

    public void setData(AttractionVO Attraction) {
        tvAttractionTitle.setText(Attraction.getAttractionTitle());
        tvAttractionDesc.setText(Attraction.getAttractionDesc());

        Glide.with(getContext())
                .load(Attraction.getDefaultImage())
                .centerCrop()
                .placeholder(R.drawable.drawer_background)
                .into(ivStockPhoto);
    }
}

