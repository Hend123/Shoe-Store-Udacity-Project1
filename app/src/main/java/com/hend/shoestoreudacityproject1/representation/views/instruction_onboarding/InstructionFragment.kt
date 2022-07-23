package com.hend.shoestoreudacityproject1.representation.views.instruction_onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.hend.shoestoreudacityproject1.R
import com.hend.shoestoreudacityproject1.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {
    private var _binding: FragmentInstructionBinding? = null
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
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.btnNavNext.setOnClickListener {
            setupNav()
        }
        return binding.root
    }
    private fun setupNav(){
        findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}