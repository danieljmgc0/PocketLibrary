package com.knighttech.pocketlibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform