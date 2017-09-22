package com.quemb.qmbform.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.EditText;

import com.quemb.qmbform.R;

/**
 * Created by macadmin on 9/22/17.
 */

/**https://stackoverflow.com/a/40379564/5845024*/
public class RoundedBorderedTextInputLayout extends TextInputLayout {
    private Context context;

    public RoundedBorderedTextInputLayout(Context context) {
        super(context);
        this.context = context;
    }

    public RoundedBorderedTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public RoundedBorderedTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();

        EditText editText = getEditText();
        if(editText != null) {
            editText.setBackground(ContextCompat.getDrawable(this.context, R.drawable.edit_text_area_create));
        }
    }

    @Override
    public void setError(@Nullable final CharSequence error) {
        super.setError(error);

        EditText editText = getEditText();
        if(editText != null) {
            editText.setBackground(ContextCompat.getDrawable(this.context, R.drawable.edit_text_area_create));
        }
    }
}