package com.rariki.kmm_base_project

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello aaaa, ${platform.name}!"
    }
}