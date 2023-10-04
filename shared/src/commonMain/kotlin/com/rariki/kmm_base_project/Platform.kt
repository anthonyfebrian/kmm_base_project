package com.rariki.kmm_base_project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform