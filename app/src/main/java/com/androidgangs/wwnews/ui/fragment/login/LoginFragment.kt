package com.androidgangs.wwnews.ui.fragment.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidgangs.wwnews.R
import com.androidgangs.wwnews.data.repo.AuthRepo
import com.androidgangs.wwnews.data.source.local.DataSource
import com.androidgangs.wwnews.data.source.local.UsersDao
import com.androidgangs.wwnews.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    lateinit var binding :LoginFragmentBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //UsersDao

        viewModel =ViewModelProvider(this).get(LoginViewModel::class.java)

        //ViewModelProvider(this,LoginViewModelFactory(AuthRepo(DataSource(usersDao =)))).get(LoginViewModel::class.java)





        // TODO: Use the ViewModel
    }

}