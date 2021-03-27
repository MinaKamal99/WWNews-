package com.androidgangs.wwnews.ui.fragment.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.androidgangs.wwnews.R
import com.androidgangs.wwnews.ServiceLocator
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
        val serviceLocator=ServiceLocator.createRepo(requireActivity().application)
        val authRepo =AuthRepo(serviceLocator.dataSource)
        val factory =LoginViewModelFactory(authRepo)
        viewModel =ViewModelProvider(this,factory).get(LoginViewModel::class.java)
        binding.viewModel=viewModel
        binding.signup.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_registrationFragment)

        }
        viewModel.errorLveData.observe(viewLifecycleOwner){ error->

            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            error?.let{
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.gotoHomeLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Yes Good", Toast.LENGTH_SHORT).show()

        }

    }

}