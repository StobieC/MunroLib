package com.example.munro

data class MunroResult(val name: String, val heightMetre: Int, val hillCategory: MunType, val gridReference: String): Comparable<MunroResult> {
    override fun compareTo(other: MunroResult): Int {
        return heightMetre.compareTo(other.heightMetre)
    }
}

enum class MunType {
    MUN,
    TOP,
    BLANK
}