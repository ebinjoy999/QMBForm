package com.quemb.qmbform.view;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.SeekBar;

/**
 * Created by ebinjoy999 on 09/09/17.
 */

public class CustomSeekBar extends AppCompatSeekBar {


    int SEEKBAR_MULTIPLIER = 1;

    public CustomSeekBar(Context context) {
        super(context);
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSeekBarConfig( int SEEKBAR_MULTIPLIER, int SEEKBAR_MAX){
        setMax(SEEKBAR_MAX);
        this.SEEKBAR_MULTIPLIER = SEEKBAR_MULTIPLIER;
    }

    @Override
    public int getProgress() {
        return super.getProgress() * SEEKBAR_MULTIPLIER;
    }

    @Override
    public  void setProgress(int progress) {
        if(progress!=0)super.setProgress(progress/SEEKBAR_MULTIPLIER);
        else super.setProgress(progress);
    }
}
