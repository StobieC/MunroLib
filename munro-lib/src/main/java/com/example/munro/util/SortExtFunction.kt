package com.example.munro.util

import com.example.munro.MunType
import com.example.munro.Munro
import java.util.*


fun MutableList<Munro>.sortByHeight(heightOrderingSortType: OrderingSortType = OrderingSortType.NONE, minHeight:Int = 0, maxHeight: Int = Int.MAX_VALUE, hillCategory: MunType = MunType.BLANK): List<Munro> {

    if (heightOrderingSortType == OrderingSortType.ASCENDING) {
        this.sortBy { it.heightMetre }
    } else if (heightOrderingSortType == OrderingSortType.DESCENDING) {
        this.sortByDescending { it.heightMetre }
    }

    if (minHeight > 0) {
        this.removeAll { it.heightMetre < minHeight }
    }
    if (maxHeight < Integer.MAX_VALUE) {
        this.removeAll { it.heightMetre > maxHeight }
    }

   return this
}

enum class OrderingSortType {
    ASCENDING,
    DESCENDING,
    NONE
}
