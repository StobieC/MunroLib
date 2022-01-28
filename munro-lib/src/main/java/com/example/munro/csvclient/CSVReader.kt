package com.example.munro.csvclient

import com.example.munro.MunType
import com.example.munro.MunroResult
import com.example.munro.bigOlCsv
import java.io.*

class CSVReader {

    companion object {
        @Throws(FileNotFoundException::class, IOException::class)
        fun readCSV(): MutableList<MunroResult> {
            val br = BufferedReader(StringReader(bigOlCsv))
            return munList(br)
        }

        fun readCSV(file: BufferedInputStream): MutableList<MunroResult> {
            val br = file.bufferedReader()
            //skip first line
            br.readLine()
            return munList(br)
        }

        private fun munType(munString: String): MunType {
            return if (munString == "MUN") { MunType.MUN } else if (munString == "TOP") { MunType.TOP} else { MunType.BLANK}
        }

        private fun munList(br: BufferedReader): MutableList<MunroResult> {
            val munroResults = mutableListOf<MunroResult>()
            br.forEachLine {
                val fields = it.split(",".toRegex()).toTypedArray()

                val name            = fields[6]
                val heightMetre     = fields[10]
                val gridRef         = fields[14]
                val postNineteen97  = munType(fields[28])



                if (name.isNotBlank() && heightMetre.isNotBlank() && gridRef.isNotBlank())
                    munroResults.add(MunroResult(name, heightMetre.toDouble(), postNineteen97, gridRef))
            }

            br.close()
            return munroResults
        }

    }
}