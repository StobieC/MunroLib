package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.munro.Munro
import com.example.munro.csvclient.CSVReader

class MainActivity : AppCompatActivity() {

    private var munros = emptyList<Munro>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val csvReader = CSVReader()
        munros = csvReader.readCSV()

        for (mun in munros) {
            Log.d("MUNRO", mun.name)
        }
    }
}