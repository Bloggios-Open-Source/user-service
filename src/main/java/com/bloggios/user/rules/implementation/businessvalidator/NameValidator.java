package com.bloggios.user.rules.implementation.businessvalidator;

import com.bloggios.user.constants.DataErrorCodes;
import com.bloggios.user.constants.ServiceConstants;
import com.bloggios.user.exception.payload.BadRequestException;
import com.bloggios.user.rules.BusinessValidator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.rules.implementation.businessvalidator
 * Created_on - May 13 - 2024
 * Created_at - 17:39
 */

@Component
public class NameValidator implements BusinessValidator<String> {

    @Override
    public void validate(String name) {
        if (Objects.isNull(name)) throw new BadRequestException(DataErrorCodes.NAME_MANDATORY);
        Pattern pattern = Pattern.compile(ServiceConstants.NAME_REGEX);
        boolean matches = pattern.matcher(name).matches();
        if (!matches) {
            throw new BadRequestException(DataErrorCodes.NAME_NOT_VALID);
        }
    }
}
