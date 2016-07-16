package com.padc.aml.attractioninmyanmar.data.models;

import com.google.gson.reflect.TypeToken;
import com.padc.aml.attractioninmyanmar.data.vos.AttractionVO;
import com.padc.aml.attractioninmyanmar.utils.CommonInstances;
import com.padc.aml.attractioninmyanmar.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/9/2016.
 */
public class AttractionModel {

    private static final String DUMMY_Attraction_LIST = "myanmar_attractions.json";

    private static AttractionModel objInstance;

    private List<AttractionVO> AttractionList;

    private AttractionModel(){
        AttractionList = initializeAttractionList();
    }

    public static AttractionModel getInstance(){
        if(objInstance == null) {
            objInstance = new AttractionModel();
        }

        return objInstance;
    }

    private List<AttractionVO> initializeAttractionList() {
        List<AttractionVO> AttractionList = new ArrayList<>();

        try {
            String dummyEventList = JsonUtils.getInstance().loadDummyData(DUMMY_Attraction_LIST);
            Type listType = new TypeToken<List<AttractionVO>>() {
            }.getType();
            AttractionList = CommonInstances.getGsonInstance().fromJson(dummyEventList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return AttractionList;
    }

    public List<AttractionVO> getAttractionList() {
        return AttractionList;
    }

    public AttractionVO getAttractionByTitle(String title){
        for(AttractionVO vo: AttractionList){
            if(vo.getAttractionTitle().equals(title))
                return vo;
        }
        return null;
    }
}