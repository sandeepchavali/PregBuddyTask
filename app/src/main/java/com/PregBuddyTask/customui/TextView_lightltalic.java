package com.PregBuddyTask.customui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.PregBuddyTask.R;

/**
 * Created by chavali on 2018-03-22.
 */

public class TextView_lightltalic extends android.support.v7.widget.AppCompatTextView {

    public TextView_lightltalic(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public TextView_lightltalic(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public TextView_lightltalic(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);

            String fontName = a.getString(R.styleable.MyTextView_aller_Ltlt);
            if (fontName != null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/aller_LtIt.ttf");
                setTypeface(myTypeface);
            }
            a.recycle();
        }
    }

}
