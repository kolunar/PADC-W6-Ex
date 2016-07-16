package com.padc.aml.attractioninmyanmar.components.buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.padc.aml.attractioninmyanmar.utils.MMFontUtils;

/**
 * Created by user on 7/9/2016.
 */
public class MMButton extends Button {

    public MMButton(Context context) {
        super(context);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    public MMButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }
}
