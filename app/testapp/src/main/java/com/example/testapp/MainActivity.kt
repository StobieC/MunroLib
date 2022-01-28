package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.munro.Munro
import com.example.munro.csvclient.CSVReader
import com.example.munro.util.OrderingSortType
import com.example.munro.util.SortingCategory
import com.example.munro.util.filterMunro

class MainActivity : AppCompatActivity() {

    private var munros = mutableListOf<Munro>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val csvReader = CSVReader()
        munros = csvReader.readCSV()
        munros.filterMunro(sortingCategory = SortingCategory.ALPHABETICALLY, orderingSortType = OrderingSortType.DESCENDING)
        for (mun in munros) {
            Log.d("MUNRO", mun.name)
        }
    }
}