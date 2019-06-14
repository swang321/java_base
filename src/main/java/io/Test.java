package io;

import java.time.LocalDateTime;

/**
 * @Author whh
 */
public class Test {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.toLocalDate().toString());

    }

}
