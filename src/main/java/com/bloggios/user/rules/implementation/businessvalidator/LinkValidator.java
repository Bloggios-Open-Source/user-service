package com.bloggios.user.rules.implementation.businessvalidator;

import com.bloggios.user.constants.DataErrorCodes;
import com.bloggios.user.constants.ServiceConstants;
import com.bloggios.user.exception.payload.BadRequestException;
import com.bloggios.user.rules.BusinessValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.rules.implementation.businessvalidator
 * Created_on - May 13 - 2024
 * Created_at - 21:28
 */

@Component
public class LinkValidator implements BusinessValidator<String> {

    @Override
    public void validate(String link) {
        if (StringUtils.hasText(link)) {
            if (link.startsWith(ServiceConstants.UNSECURED_PROTOCOL))
                throw new BadRequestException(DataErrorCodes.UNSECURED_PROTOCOL);
            if (!link.startsWith(ServiceConstants.SECURED_PROTOCOL))
                throw new BadRequestException(DataErrorCodes.LINK_PROTOCOL_NOT_PRESENT);
        }
    }
}
