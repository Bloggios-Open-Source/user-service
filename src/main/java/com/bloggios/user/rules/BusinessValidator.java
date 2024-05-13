package com.bloggios.user.rules;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.rules
 * Created_on - May 13 - 2024
 * Created_at - 17:37
 */

@FunctionalInterface
public interface BusinessValidator<A> {

    void validate(A a);
}
