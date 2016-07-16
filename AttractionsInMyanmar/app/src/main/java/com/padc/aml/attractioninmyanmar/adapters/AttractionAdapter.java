package com.padc.aml.attractioninmyanmar.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.aml.attractioninmyanmar.AttractionApp;
import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.data.vos.AttractionVO;
import com.padc.aml.attractioninmyanmar.fragments.AttractionFragment;
import com.padc.aml.attractioninmyanmar.views.holders.AttractionViewHolder;

import java.util.List;

/**
 * Created by user on 7/9/2016.
 */
public class AttractionAdapter extends RecyclerView.Adapter<AttractionViewHolder> {

    private LayoutInflater inflater;
    private List<AttractionVO> AttractionList;
    private AttractionFragment.ControllerAttractionItem mAttractionItemController;

    public AttractionAdapter(List<AttractionVO> AttractionList, AttractionFragment.ControllerAttractionItem AttractionItemController) {
        inflater = LayoutInflater.from(AttractionApp.getContext());
        this.AttractionList = AttractionList;
        mAttractionItemController = AttractionItemController;
    }

    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item_attraction, parent, false);
        final AttractionViewHolder AttractionVH = new AttractionViewHolder(view, mAttractionItemController);
        return AttractionVH;
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, int position) {
        holder.setData(AttractionList.get(position));
    }

    @Override
    public int getItemCount() {
        return AttractionList.size();
    }

}