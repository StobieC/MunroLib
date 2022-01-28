package com.example.munro.util

import com.example.munro.MunType
import com.example.munro.Munro
import java.util.*


fun MutableList<Munro>.sortByHeight(sortingCategory: SortingCategory = SortingCategory.NONE, orderingSortType: OrderingSortType = OrderingSortType.NONE, minHeight:Int = 0, maxHeight: Int = Int.MAX_VALUE, hillCategory: MunType = MunType.BLANK): List<Munro> {

    //filter by height
    if (minHeight > 0) {
        this.removeAll { it.heightMetre < minHeight }
    }
    if (maxHeight < Integer.MAX_VALUE) {
        this.removeAll { it.heightMetre > maxHeight }
    }

    //filter by hill category
    if (hillCategory == MunType.TOP) {
        this.removeAll { it.postNineteen97 == MunType.BLANK }
        this.removeAll { it.postNineteen97 == MunType.MUN }
    } else if(hillCategory == MunType.MUN) {
        this.removeAll { it.postNineteen97 == MunType.BLANK }
        this.removeAll { it.postNineteen97 == MunType.TOP }
    }

    //sort by height/alphabetically
    if (sortingCategory == SortingCategory.HEIGHT) {
        if (orderingSortType == OrderingSortType.ASCENDING) {
            this.sortBy { it.heightMetre }
        } else if (orderingSortType == OrderingSortType.DESCENDING) {
            this.sortByDescending { it.heightMetre }
        }
    } else if (sortingCategory == SortingCategory.ALPHABETICALLY) {
        if (orderingSortType == OrderingSortType.ASCENDING) {
            this.sortBy { it.name }
        } else if (orderingSortType == OrderingSortType.DESCENDING) {
            this.sortByDescending { it.name }
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
