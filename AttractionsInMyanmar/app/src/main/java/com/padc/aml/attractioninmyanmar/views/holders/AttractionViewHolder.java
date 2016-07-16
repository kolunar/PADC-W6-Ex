package com.padc.aml.attractioninmyanmar.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.data.vos.AttractionVO;
import com.padc.aml.attractioninmyanmar.fragments.AttractionFragment;

/**
 * Created by user on 7/9/2016.
 */
public class AttractionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvAttractionTitle;
    private ImageView ivStockPhoto;
    private TextView tvAttractionDesc;

    private AttractionVO mAttraction;
    private AttractionFragment.ControllerAttractionItem mAttractionItemController;

    public AttractionViewHolder(View view, AttractionFragment.ControllerAttractionItem AttractionItemController) {
        super(view);
        view.setOnClickListener(this);
        mAttractionItemController = AttractionItemController;

        tvAttractionTitle = (TextView) view.findViewById(R.id.tv_attraction_title);
        ivStockPhoto = (ImageView) view.findViewById(R.id.iv_stock_photo);
        tvAttractionDesc = (TextView) view.findViewById(R.id.tv_attraction_desc);
    }

    public void setData(AttractionVO Attraction) {
        this.mAttraction = Attraction;

        tvAttractionTitle.setText(Attraction.getAttractionTitle());
        tvAttractionDesc.setText(Attraction.getAttractionDesc());

        Glide.with(ivStockPhoto.getContext())
                .load(Attraction.getDefaultImage())
                .centerCrop()
                .placeholder(R.drawable.drawer_background)
                .into(ivStockPhoto);
    }

    @Override
    public void onClick(View view) {
        mAttractionItemController.onTapAttraction(mAttraction, ivStockPhoto);
    }

}