package com.kotovdv.just.messenger

import org.springframework.boot.Banner.Mode.OFF
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class JustMessenger {

    fun main(args: Array<String>) {
        SpringApplicationBuilder(JustMessenger::class.java)
                .bannerMode(OFF)
                .web(false)
                .run(*args)
    }
}
