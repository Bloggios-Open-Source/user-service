package com.bloggios.user.rules.implementation.businessvalidator;

import com.bloggios.user.constants.DataErrorCodes;
import com.bloggios.user.exception.payload.BadRequestException;
import com.bloggios.user.exception.payload.InternalException;
import com.bloggios.user.rules.BusinessValidator;
import com.bloggios.user.utils.WordsCounter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.rules.implementation.businessvalidator
 * Created_on - May 13 - 2024
 * Created_at - 18:00
 */

@Component
public class BioValidator implements BusinessValidator<String> {

    @Override
    public void validate(String bio) {
        if (StringUtils.hasText(bio)) {
            if (bio.length() > 150) throw new BadRequestException(DataErrorCodes.BIO_LENGTH_EXCEED);
            int words = WordsCounter.countWords(bio);
            if (words > 25) throw new BadRequestException(DataErrorCodes.BIO_WORD_LIMIT_EXCEED);
            int lines = countNewLines(bio);
            if (lines >= 3) {
                throw new BadRequestException(DataErrorCodes.BIO_LINES_EXCEED);
            }
        }
    }

    private static int countNewLines(String data) {
        int count = 0;
        int index = data.indexOf('\n');
        while(index != -1) {
            count++;
            index = data.indexOf('\n', index + 1);
        }
        return count;
    }
}
