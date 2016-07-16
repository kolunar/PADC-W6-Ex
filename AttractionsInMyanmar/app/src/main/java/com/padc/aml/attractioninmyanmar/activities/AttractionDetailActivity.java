package com.padc.aml.attractioninmyanmar.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.aml.attractioninmyanmar.AttractionApp;
import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.data.models.AttractionModel;
import com.padc.aml.attractioninmyanmar.data.vos.AttractionVO;
import com.padc.aml.attractioninmyanmar.utils.AttractionConstants;

public class AttractionDetailActivity extends AppCompatActivity {

    private static final String IE_EVENT_TITLE = "IE_EVENT_TITLE";

    private ImageView ivAttractionPhoto;
    private TextView tvAttractionDesc;
    private CollapsingToolbarLayout collapsingToolbar;

    public static Intent newIntent(String attractionTitle) {
        Intent intent = new Intent(AttractionApp.getContext(), AttractionDetailActivity.class);
        intent.putExtra(IE_EVENT_TITLE, attractionTitle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivAttractionPhoto = (ImageView) findViewById(R.id.iv_stock_photo);
        // to gracefully fallback if version leass than 21
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            Context context = AttractionApp.getContext();
            String transitionName = context.getResources().getString(R.string.attraction_stock_photo_shared_transition);
            ivAttractionPhoto.setTransitionName(transitionName);
        }

        tvAttractionDesc = (TextView) findViewById(R.id.tv_attraction_desc);
        tvAttractionDesc.setMaxLines(Integer.MAX_VALUE);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_accent_24dp);
        }

        String attractionTitle = getIntent().getStringExtra(IE_EVENT_TITLE);

        final AttractionVO attraction = AttractionModel.getInstance().getAttractionByTitle(attractionTitle);
        if(attraction == null) {
            throw new RuntimeException("Can't find Attraction obj with the title : "+attractionTitle);
        } else {
            collapsingToolbar.setTitle(attraction.getAttractionTitle());
            tvAttractionDesc.setText(attraction.getAttractionDesc() + "\n\n" +
                    attraction.getAttractionDesc() + "\n\n" +
                    attraction.getAttractionDesc() + "\n\n" +
                    attraction.getAttractionDesc() + "\n\n" +
                    attraction.getAttractionDesc());

            Glide.with(ivAttractionPhoto.getContext())
                    .load(attraction.getDefaultImage())
                    .centerCrop()
                    .placeholder(R.drawable.drawer_background)
                    .into(ivAttractionPhoto);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_sharing);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imageUrl = AttractionConstants.IMAGE_ROOT_DIR + attraction.getDefaultImage();
                startActivity(Intent.createChooser(ShareCompat.IntentBuilder.from(AttractionDetailActivity.this)
                        .setType("text/plain")
                        .setText(attraction.getAttractionTitle() + " - " + imageUrl)
                        .getIntent(), getString(R.string.action_share)));
/*                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
    }


}
