package com.kotovdv.just.messenger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.springframework.boot.Banner.Mode.OFF;

/**
 * @author Dmitriy Kotov
 */
@SpringBootApplication
public class JustMessenger {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JustMessenger.class)
                .bannerMode(OFF)
                .web(false)
                .run(args);
    }
}
