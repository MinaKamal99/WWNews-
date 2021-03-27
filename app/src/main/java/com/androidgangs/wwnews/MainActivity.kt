package com.androidgangs.wwnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.androidgangs.wwnews.databinding.ActivityMainBinding
import com.androidgangs.wwnews.ui.fragment.login.LoginFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/


        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
            LoginFragment()
        ).commit()
    }
}