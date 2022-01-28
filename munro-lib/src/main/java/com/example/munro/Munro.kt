package com.example.munro

data class Munro(val runningNo: String, val dobihNo: String, val streetmapUrl: String,
                 val geographUrl: String, val hillBaggingUrl: String, val name: String,
                 val smcSection: String, val rhbSection: String, val section: String,
                 val heightMetre: Int, val heightFt: Int, val map150: String, val map125 : String,
                 val gridRef: String, val gridRefXY: String, val xcoord: String, val ycoord: String,
                 val eighteen91: MunType, val nineteen21: MunType, val nineseen33: MunType,
                 val nineteen53: MunType, val nineteen69: MunType, val nineteen71: MunType,
                 val nineteen81: MunType, val nineteen84: MunType, val nineteen90: MunType,
                 val nineteen97:MunType, val postNineteen97: MunType, val comments: String) : Comparable<Munro> {


    override fun compareTo(other: Munro): Int {
      return heightMetre.compareTo(other.heightMetre)
    }
}

enum class MunType {
    MUN,
    TOP,
    BLANK
}