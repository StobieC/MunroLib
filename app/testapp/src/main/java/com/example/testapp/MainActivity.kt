package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.munro.MunroResult
import com.example.munro.csvclient.CSVReader
import com.example.munro.util.OrderingSortType
import com.example.munro.util.SortingCategory
import com.example.munro.util.filterMunro

class MainActivity : AppCompatActivity() {

    private var munros = mutableListOf<MunroResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        munros = CSVReader.readCSV()
        munros.filterMunro(minHeight = 950)
        munros.filter { it.heightMetre > 975 }
        for (mun in munros) {
            Log.d("MUNRO", "${mun.name} ${mun.heightMetre}")
        }

        Log.d("MUNRo", "${munros.filterMunro(minHeight = 950).size}")
    }
}