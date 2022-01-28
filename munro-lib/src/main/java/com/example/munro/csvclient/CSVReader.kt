package com.example.munro.csvclient

import com.example.munro.MunType
import com.example.munro.MunroResult
import com.example.munro.bigOlCsv
import java.io.*

class CSVReader {

    @Throws(FileNotFoundException::class, IOException::class)
    fun readCSV(): MutableList<MunroResult> {
        val munroResults = mutableListOf<MunroResult>()

        val br = BufferedReader(StringReader(bigOlCsv))

        br.forEachLine {
            val fields = it.split(",".toRegex()).toTypedArray()
            val name            = fields[5]
            val heightMetre     = fields[9]
            val gridRef         = fields[13]
            val postNineteen97  = munType(fields[27])

            munroResults.add(MunroResult(name, Integer.parseInt(heightMetre), postNineteen97, gridRef))
        }

        br.close()
        return munroResults
    }

    private fun munType(munString: String): MunType {
        return if (munString == "MUN") { MunType.MUN } else if (munString == "TOP") { MunType.TOP} else { MunType.BLANK}
    }
}