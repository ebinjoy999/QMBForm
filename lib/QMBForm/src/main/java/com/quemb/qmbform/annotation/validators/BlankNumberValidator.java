package com.quemb.qmbform.annotation.validators;

import com.quemb.qmbform.R;
import com.quemb.qmbform.annotation.FormValidator;
import com.quemb.qmbform.descriptor.RowDescriptor;
import com.quemb.qmbform.descriptor.RowValidationError;
import com.quemb.qmbform.descriptor.Value;

/**
 * Created by ebinjoy999 on 19/06/18.
 */

public class BlankNumberValidator implements FormValidator {
    @Override
    public RowValidationError validate(RowDescriptor descriptor) {
        Value value = descriptor.getValue();
        if (value.getValue() != null &&
                (value.getValue() instanceof Number || value.getValue() instanceof String)) {
//            Number number = (Number) value.getValue();
            // if a valid string return null
            if (value.getValue().toString().length() > 0) {
                return null;
            }
        }
        return new RowValidationError(descriptor, R.string.validation_is_required);
    }
}
