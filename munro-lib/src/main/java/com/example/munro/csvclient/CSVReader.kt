package com.example.munro.csvclient

import com.example.munro.MunType
import com.example.munro.Munro
import com.example.munro.bigOlCsv
import java.io.*

class CSVReader {

    @Throws(FileNotFoundException::class, IOException::class)
    fun readCSV(): MutableList<Munro> {
        val munros = mutableListOf<Munro>()

        val br = BufferedReader(
            StringReader(bigOlCsv)
        )

        br.forEachLine {
            val fields = it.split(",".toRegex()).toTypedArray()
            val runningNo       = fields[0]
            val dobihNumber     = fields[1]
            val streetmapUrl    = fields[2]
            val geographUrl     = fields[3]
            val hillBaggingUrl  = fields[4]
            val name            = fields[5]
            val smcSection      = fields[6]
            val rhbSection      = fields[7]
            val section         = fields[8]
            val heightMetre     = fields[9]
            val heightFt        = fields[10]
            val map150          = fields[11]
            val map125          = fields[12]
            val gridRef         = fields[13]
            val gridRefXy       = fields[14]
            val xCoord          = fields[15]
            val yCoord          = fields[16]
            val eighten81       = munType(fields[17])
            val nineteen21      = munType(fields[18])
            val nineteen33      = munType(fields[19])
            val ninteen53       = munType(fields[20])
            val nineteen69      = munType(fields[21])
            val nineteen74      = munType(fields[22])
            val nineteen81      = munType(fields[23])
            val nineteen84      = munType(fields[24])
            val nineteen90      = munType(fields[25])
            val nineteen97      = munType(fields[26])
            val postNineteen97  = munType(fields[27])

            munros.add(Munro(runningNo, dobihNumber, streetmapUrl, geographUrl, hillBaggingUrl, name,
                smcSection, rhbSection, section, Integer.parseInt(heightMetre), Integer.parseInt(heightFt), map150, map125, gridRef,
                gridRefXy, xCoord, yCoord, eighten81, nineteen21, nineteen33, ninteen53,
                nineteen69, nineteen74, nineteen81, nineteen84, nineteen90, nineteen97,
                postNineteen97, "comments"))
        }

        br.close()

        for (mun in munros) {
            print(mun.name)
        }
        return munros
    }

    private fun munType(munString: String): MunType {
        return if (munString == "MUN") { MunType.MUN } else if (munString == "TOP") { MunType.TOP} else { MunType.BLANK}
    }
}