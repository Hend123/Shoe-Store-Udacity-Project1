package com.hend.shoestoreudacityproject1.representation.views.welcome_onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.hend.shoestoreudacityproject1.R
import com.hend.shoestoreudacityproject1.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.btnNavNext.setOnClickListener {
            setupNav()
        }
        return binding.root
    }

    private fun setupNav(){
        findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}