package com.rariki.kmmbaseproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform