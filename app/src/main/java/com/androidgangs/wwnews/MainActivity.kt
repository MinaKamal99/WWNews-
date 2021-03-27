package com.androidgangs.wwnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidgangs.wwnews.data.source.local.DataSource
import com.androidgangs.wwnews.data.source.local.UsersDao
import com.androidgangs.wwnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,LoginFragment()).commit()
    }
}