package com.example.vabyarstest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.vabyarstest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var number = 0
    private lateinit var binding: ActivityMainBinding
    private val loggingTag = "Main activity action"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNumberToView()

        binding.secondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(IntentKeys.NUMBER.name, number)
            }
            startActivity(intent)
        }

        Log.i(loggingTag, "Activity created")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(IntentKeys.NUMBER.name, number)
        Log.i(loggingTag, "Activity save instance state")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(IntentKeys.NUMBER.name)) {
            number = savedInstanceState.getInt(IntentKeys.NUMBER.name) + 1
            setNumberToView()
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

    private fun setNumberToView(){
        binding.number.text = number.toString()
    }
}