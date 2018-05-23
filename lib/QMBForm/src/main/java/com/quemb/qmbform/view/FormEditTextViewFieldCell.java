package com.quemb.qmbform.view;

import android.content.Context;
import android.support.design.widget.TextInputEditText;

import com.quemb.qmbform.R;
import com.quemb.qmbform.descriptor.RowDescriptor;

/**
 * Created by tonimoeckel on 15.07.14.
 */
public class FormEditTextViewFieldCell extends FormEditTextFieldCell {

    public FormEditTextViewFieldCell(Context context,
                                     RowDescriptor rowDescriptor) {
        super(context, rowDescriptor);
    }

    @Override
    protected void init() {
        super.init();
        super.mEditView = (TextInputEditText) findViewById(R.id.editText);
    }

    @Override
    protected void update() {
        super.update();
    }

    @Override
    protected int getResource() {
        return R.layout.edit_text_view_field_cell;
    }
}
