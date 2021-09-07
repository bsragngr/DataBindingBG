package com.example.databindingbg

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingbg.data.Student
import com.example.databindingbg.databinding.ActivityMainBinding
import com.example.databindingbg.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.student = getStudent()

        binding.bindBtn.setOnClickListener {
            displayName()
        }

        binding.loadingBtn.setOnClickListener {
            startLoading()
        }

        binding.countText.text = viewModel.getCurrentCount().toString()
        binding.clickHereBtn.setOnClickListener {
            binding.countText.text = viewModel.getUpdatedCount().toString()
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

    private fun getStudent(): Student {
        return Student(1, "Busra", "busragungortrakya@gmail.com")
    }
}