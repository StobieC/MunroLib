package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.munro.MunroResult
import com.example.munro.csvclient.CSVReader
import com.example.munro.util.OrderingSortType
import com.example.munro.util.SortingCategory
import com.example.munro.util.filterMunro
import java.io.BufferedInputStream

class MainActivity : AppCompatActivity() {

    private var munros = mutableListOf<MunroResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file = BufferedInputStream(resources.openRawResource(R.raw.munrotab_v6))

        munros = CSVReader.readCSV(file)
        munros.filterMunro(minHeight = 950)
        for (mun in munros) {
            Log.d("MUNRO", "${mun.name} ${mun.heightMetre} ${mun.gridReference} ${mun.hillCategory}")
        }
    }
}