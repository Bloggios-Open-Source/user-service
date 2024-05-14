package com.bloggios.user.transformer;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.transformer
 * Created_on - May 14 - 2024
 * Created_at - 11:24
 */

@FunctionalInterface
public interface Transform<A, B> {

    A transform(B b);
}
