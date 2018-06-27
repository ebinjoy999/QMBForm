package com.quemb.qmbform.view;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;

import com.quemb.qmbform.R;
import com.quemb.qmbform.descriptor.CellDescriptor;
import com.quemb.qmbform.descriptor.RowDescriptor;
import com.quemb.qmbform.descriptor.Value;

/**
 * Created by tonimoeckel on 15.07.14.
 */
public class FormEditTextFieldCell extends FormTitleFieldCell {

    TextInputEditText mEditView;
    TextInputLayout  tInputLayout;

    public FormEditTextFieldCell(Context context,
                                 RowDescriptor rowDescriptor) {
        super(context, rowDescriptor);
    }

    private Handler handler = new Handler();
    private int lastFocussedPosition = -1;

    @Override
    protected void init() {
        super.init();
        mEditView = (TextInputEditText) findViewById(R.id.editText);
        mEditView.setRawInputType(InputType.TYPE_CLASS_TEXT);
        tInputLayout = (TextInputLayout) findViewById(R.id.tInputLayout);
        setStyleId(mEditView, CellDescriptor.APPEARANCE_TEXT_VALUE, CellDescriptor.COLOR_VALUE);
    }

    @Override
    protected void afterInit() {
        super.afterInit();
        mEditView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                FormEditTextFieldCell.this.onEditTextChanged(s.toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }

    protected void onEditTextChanged(String string) {
        onValueChanged(new Value<String>(string));
    }

    @Override
    protected int getResource() {
        return R.layout.edit_text_field_cell;
    }

    @Override
    protected void update() {

        super.update();

        updateEditView();

        if (getRowDescriptor().getDisabled())
        {
            mEditView.setEnabled(false);
            setTextColor(mEditView, CellDescriptor.COLOR_VALUE_DISABLED);
        }
        else
            mEditView.setEnabled(true);

    }

    protected void updateEditView() {
        updateHintErrorText();
        @SuppressWarnings("unchecked") Value<String> value = (Value<String>) getRowDescriptor().getValue();
        if (value != null && value.getValue() != null) {
            String valueString = value.getValue();
            mEditView.setText(valueString);
        }

    }

    public void updateHintErrorText() {
        if(getRowDescriptor().getErrorMessage().equals("")) {
//            mTextViewError.setVisibility(GONE);
        }else {
            if(tInputLayout!=null)tInputLayout.setError(getRowDescriptor().getErrorMessage());
            else mEditView.setError(getRowDescriptor().getErrorMessage());
//            mTextViewError.setVisibility(VISIBLE);
//            mTextViewError.setText(getRowDescriptor().getErrorMessage());
        }

        String hint = getRowDescriptor().getTitleReplacedByHint()? getRowDescriptor().getTitle() : getRowDescriptor().getHint(getContext());
        if (hint != null) {
            mEditView.setHint(hint);
        }

    }

    public EditText getEditView() {
        return mEditView;
    }


}
