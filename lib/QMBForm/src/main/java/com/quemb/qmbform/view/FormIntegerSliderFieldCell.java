package com.quemb.qmbform.view;

import com.quemb.qmbform.R;
import com.quemb.qmbform.descriptor.RowDescriptor;
import com.quemb.qmbform.descriptor.Value;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;

import java.util.HashMap;

/**
 * Created by tonimoeckel on 25.08.14.
 */
public class FormIntegerSliderFieldCell extends FormDetailTextInlineFieldCell {

    private CustomSeekBar mSeekBar;
    public final static String CellConfigMaxKey = "CellConfigMaxKey";
    public final static String CellConfigMultiplierKey = "CellConfigMultiplierKey";

    public FormIntegerSliderFieldCell(Context context, RowDescriptor rowDescriptor) {
        super(context, rowDescriptor);
    }

    @Override
    protected void init() {
        super.init();
        mSeekBar = (CustomSeekBar) findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                getDetailTextView().setText(Integer.toString(mSeekBar.getProgress()));
                onValueChanged(new Value<Integer>(mSeekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected int getResource() {
        return R.layout.integer_slider_field_cell;
    }

    @Override
    protected void update() {

        super.update();

        @SuppressWarnings("unchecked") Value<Integer> value = (Value<Integer>) getRowDescriptor().getValue();

        HashMap<String, Object> config = getRowDescriptor().getCellConfig();
        Integer max = config != null && config.containsKey(CellConfigMaxKey) ? (Integer) config.get(CellConfigMaxKey) : 100;
        Integer mult = config != null && config.containsKey(CellConfigMultiplierKey) ? (Integer) config.get(CellConfigMultiplierKey) : 1;
        mSeekBar.setSeekBarConfig(mult,max);
        mSeekBar.setProgress(value.getValue());
        mSeekBar.setEnabled(!getRowDescriptor().getDisabled());

    }

    public CustomSeekBar getSeekBar() {
        return mSeekBar;
    }
}
