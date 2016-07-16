package com.padc.aml.attractioninmyanmar.fragments;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.padc.aml.attractioninmyanmar.AttractionApp;
import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.adapters.AttractionAdapter;
import com.padc.aml.attractioninmyanmar.data.models.AttractionModel;
import com.padc.aml.attractioninmyanmar.data.vos.AttractionVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class AttractionFragment extends Fragment {

    private AttractionAdapter mAttractionAdapter;
    private ControllerAttractionItem mAttractionItemController;

    public static AttractionFragment newInstance() {
        return new AttractionFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAttractionItemController = (ControllerAttractionItem) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAttractionAdapter = new AttractionAdapter(AttractionModel.getInstance().getAttractionList(), mAttractionItemController);
        Toast.makeText(AttractionApp.getContext(), "AttractionFragment::onCreate::Size:"+mAttractionAdapter.getItemCount(), Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(AttractionApp.getContext(), "AttractionFragment::onCreateView", Toast.LENGTH_LONG).show();
        View view = inflater.inflate(R.layout.fragment_attraction, container, false);

        RecyclerView rvAttraction = (RecyclerView) view.findViewById(R.id.rv_Attractions);
        rvAttraction.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
        rvAttraction.setAdapter(mAttractionAdapter);
        Toast.makeText(AttractionApp.getContext(), "AttractionFragment::onCreateView::Size:"+mAttractionAdapter.getItemCount(), Toast.LENGTH_LONG).show();
        return view;
    }

    public interface ControllerAttractionItem {
        void onTapAttraction(AttractionVO Attraction, ImageView imageView);
    }
}