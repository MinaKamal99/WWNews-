package com.androidgangs.wwnews.ui.fragment.login.registration

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.androidgangs.wwnews.R
import com.androidgangs.wwnews.ServiceLocator
import com.androidgangs.wwnews.data.model.UserModel
import com.androidgangs.wwnews.data.repo.AuthRepo
import com.androidgangs.wwnews.databinding.RegistrationFragmentBinding

class RegistrationFragment : Fragment() {


    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private lateinit var viewModel: RegistrationViewModel
    lateinit var binding: RegistrationFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegistrationFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val serviceLocator = ServiceLocator.createRepo(requireActivity().application)
        val repo = AuthRepo(serviceLocator.dataSource)
        val registrationViewModelFactory = RegistrationViewModelFactory(repo)
        viewModel = ViewModelProvider(requireActivity(),registrationViewModelFactory).get(RegistrationViewModel::class.java)
        binding.registerButton.setOnClickListener {
            viewModel.register(binding.editTextRegisterEmail.text.toString(),binding.passwordRegisterTextView.text.toString(),binding.ConfirmPasswordTextView.text.toString())

        }

        observation(viewModel)

    }

    private fun observation(viewModel: RegistrationViewModel) {
        viewModel.success.observe(viewLifecycleOwner, Observer { doAction(it) })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer { handleError(it) })
    }

    private fun handleError(it: String?) {

    }

    private fun doAction(it: Boolean?) {
    }

}