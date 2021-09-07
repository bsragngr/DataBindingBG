package com.example.databindingbg

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databindingbg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bindBtn.setOnClickListener {
            displayName()
        }

        binding.loadingBtn.setOnClickListener {
            startLoading()
        }

    }

    private fun displayName() {
        binding.welcomeTxt.text = "Welcome, " + binding.getNameEdt.text

        /*binding.apply {
            welcomeTxt.text = "Welcome, " + getNameEdt.text
        }*/
    }

    private fun startLoading() {
        binding.apply {
            if (progressBar.visibility == View.GONE) {
                progressBar.visibility = View.VISIBLE
                loadingBtn.text = "Stop"
            } else {
                progressBar.visibility = View.GONE
                loadingBtn.text = "Start"
            }
        }
    }
}