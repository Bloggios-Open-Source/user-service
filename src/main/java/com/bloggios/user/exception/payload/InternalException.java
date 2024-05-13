package com.bloggios.user.exception.payload;

import com.bloggios.user.exception.ExceptionProvider;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.exception.payload
 * Created_on - May 13 - 2024
 * Created_at - 11:34
 */

@Getter
@EqualsAndHashCode(callSuper = true)
public class InternalException extends ExceptionProvider {

    public InternalException(String code) {
        super(code);
    }
}
