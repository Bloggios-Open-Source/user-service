package com.bloggios.user.utils;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.utils
 * Created_on - May 13 - 2024
 * Created_at - 18:00
 */

@UtilityClass
public class WordsCounter {

    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.split("\\s+");
        return (int) Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .count();
    }
}
