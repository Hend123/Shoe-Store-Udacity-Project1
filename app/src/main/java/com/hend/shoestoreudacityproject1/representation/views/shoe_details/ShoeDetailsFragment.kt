package com.hend.shoestoreudacityproject1.representation.views.shoe_details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hend.shoestoreudacityproject1.R
import com.hend.shoestoreudacityproject1.databinding.FragmentShoeDetailsBinding
import com.hend.shoestoreudacityproject1.models.Shoe
import com.hend.shoestoreudacityproject1.representation.view_models.SharedVM


class ShoeDetailsFragment : Fragment() {
    private var _binding: FragmentShoeDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedVM by activityViewModels()

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
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.shoeVm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        // setupVM()
        binding.btnSaveShoeDetails.setOnClickListener {
            saveShoeInList()
            // Log.d("test", binding.inputShoeName.text.toString())
            setupNav()

        }
        binding.btnCancelShoeDetails.setOnClickListener {
            setupNav()
        }


        return binding.root
    }


    private fun saveShoeInList() {
        viewModel.setShoe()
    }

    private fun setupNav() {
        findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
    }

    companion object {

        fun newInstance() =
            ShoeDetailsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}