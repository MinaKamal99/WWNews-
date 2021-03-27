package com.androidgangs.wwnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.androidgangs.wwnews.databinding.ActivityMainBinding
import com.androidgangs.wwnews.ui.fragment.login.FavouriteFragment
import com.androidgangs.wwnews.ui.fragment.login.LoginFragment
import com.androidgangs.wwnews.ui.fragment.login.registration.RegistrationFragment
import com.androidgangs.wwnews.ui.news.NewsFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
//            LoginFragment()
//        ).commit()


        binding.menuBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view_tag, NewsFragment()).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favo -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view_tag, RegistrationFragment()).commit()
                    return@setOnNavigationItemSelectedListener true
                }

                else ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view_tag, LoginFragment()).commit()
                    return@setOnNavigationItemSelectedListener true

                }
            }

            }

        }
    }