package com.padc.aml.attractioninmyanmar.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 7/9/2016.
 */
public class AttractionVO{
    @SerializedName("title")
    private String AttractionTitle;

    @SerializedName("desc")
    private String AttractionDesc;

    @SerializedName("images")
    private String[] AttractionImages;

    public AttractionVO(String AttractionTitle, String AttractionDesc, String[] AttractionImages) {
        this.AttractionTitle = AttractionTitle;
        this.AttractionImages = AttractionImages;
        this.AttractionDesc = AttractionDesc;
    }

    public String getAttractionTitle() {
        return AttractionTitle;
    }

    public String[] getAttractionImages() {
        return AttractionImages;
    }

    public static String IMAGES_URL = "http://www.aungpyaephyo.xyz/myanmar_attractions/";
    public String getDefaultImage() {
        return IMAGES_URL + AttractionImages[0];
    }

    public String getAttractionDesc() {
        return AttractionDesc;
    }

}