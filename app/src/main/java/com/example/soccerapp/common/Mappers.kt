package com.example.soccerapp.common

fun Char?.getFormattedPlayerPosition(): String {
    return when(this) {
        'G' -> "Goalkeeper"
        'D' -> "Defender"
        'M' -> "Midfielder"
        'F' -> "Forward"
        else -> "Unknown"
    }
}