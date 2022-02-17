package com.example.vabyarstest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.vabyarstest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private var squaredNumber = 0
    private lateinit var binding: ActivitySecondBinding
    private val loggingTag = "Second activity action"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentNumber = intent.getIntExtra(IntentKeys.NUMBER.name, 0)
        squaredNumber = intentNumber * intentNumber
        setSquaredNumberToView()

        Log.i(loggingTag, "Activity created")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(IntentKeys.SQUARED_NUMBER.name, squaredNumber)
        Log.i(loggingTag, "Activity save instance state")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(IntentKeys.SQUARED_NUMBER.name)) {
            squaredNumber = savedInstanceState.getInt(IntentKeys.SQUARED_NUMBER.name)
            setSquaredNumberToView()
        }
        Log.i(loggingTag, "Activity restore instance state")
    }

    override fun onResume() {
        super.onResume()
        Log.i(loggingTag, "Activity resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(loggingTag, "Activity pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(loggingTag, "Activity stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(loggingTag, "Activity restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(loggingTag, "Activity destroy")
    }

    private fun setSquaredNumberToView() {
        binding.squaredNumber.text = squaredNumber.toString()
    }
}