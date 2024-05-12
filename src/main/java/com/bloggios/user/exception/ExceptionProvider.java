package com.bloggios.user.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.exception
 * Created_on - May 12 - 2024
 * Created_at - 22:01
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ExceptionProvider extends RuntimeException {

    private final String code;
}
