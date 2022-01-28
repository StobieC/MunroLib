package com.example.munro.util

import com.example.munro.MunType
import com.example.munro.MunroResult

fun MutableList<MunroResult>.filterMunro(sortingCategory: SortingCategory = SortingCategory.NONE,
                                         orderingSortType: OrderingSortType = OrderingSortType.NONE,
                                         minHeight:Int = 0, maxHeight: Int = Int.MAX_VALUE,
                                         hillCategory: MunType = MunType.BLANK, resultsLimit: Int = 0): List<MunroResult> {

//    filter by height
    if (minHeight > 0) {
        this.removeAll { it.heightMetre < minHeight }
    }
    if (maxHeight < Integer.MAX_VALUE) {
        this.removeAll { it.heightMetre > maxHeight }
    }

    //filter by hill category
    if (hillCategory == MunType.TOP) {
        this.removeAll { it.hillCategory == MunType.BLANK }
        this.removeAll { it.hillCategory == MunType.MUN }
    } else if(hillCategory == MunType.MUN) {
        this.removeAll { it.hillCategory == MunType.BLANK }
        this.removeAll { it.hillCategory == MunType.TOP }
    }

    //sort by height/alphabetically
    if (sortingCategory == SortingCategory.HEIGHT) {
        if (orderingSortType == OrderingSortType.ASCENDING) {
            this.sortedWith(compareBy<MunroResult> {it.heightMetre}.thenBy { it.name })
        } else if (orderingSortType == OrderingSortType.DESCENDING) {
            this.sortedWith(compareBy<MunroResult> {it.heightMetre}.thenBy { it.name }).reversed()
        }
    } else if (sortingCategory == SortingCategory.ALPHABETICALLY) {
        if (orderingSortType == OrderingSortType.ASCENDING) {
            this.sortBy { it.name }
        } else if (orderingSortType == OrderingSortType.DESCENDING) {
            this.sortByDescending { it.name }
        }
    }

    //Limit to top x results
    if (resultsLimit > 0) {
        for ((index) in this.withIndex()) {
             if (index > resultsLimit) this.removeAt(index)
        }
    }

   return this
}

enum class SortingCategory {
    ALPHABETICALLY,
    HEIGHT,
    NONE
}

enum class OrderingSortType {
    ASCENDING,
    DESCENDING,
    NONE
}
