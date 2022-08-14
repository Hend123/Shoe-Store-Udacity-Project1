package com.hend.shoestoreudacityproject1.representation.views.shoe_list

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.hend.shoestoreudacityproject1.R
import com.hend.shoestoreudacityproject1.databinding.FragmentShoeListBinding
import com.hend.shoestoreudacityproject1.databinding.RvItemBinding
import com.hend.shoestoreudacityproject1.models.Shoe
import com.hend.shoestoreudacityproject1.representation.view_models.SharedVM


class ShoeListFragment : Fragment() {
    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedVM by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
//        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbarLogout)
        //setHasOptionsMenu(true)
        observeShoeList(container)
        binding.fabNavShoeDetail.setOnClickListener {
            setupNav()
        }
        return binding.root
    }
    //اثممخ

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun observeShoeList(container: ViewGroup?) {
        viewModel.shoeList.observe(viewLifecycleOwner) {
            for (shoe in it) {
                addShoeToView(container = container, shoe)
            }
        }
    }

    private fun addShoeToView(container: ViewGroup?, shoe: Shoe) {
        val shoeBinding: RvItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.rv_item, container, false)
        shoeBinding.shoe = shoe
        binding.shoeContainer.addView(shoeBinding.root)

    }

    private fun setupNav() {
        findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
    }


//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu, menu)
//    }

    //
//
//    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
//        R.id.logout -> {
//            findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
//            true
//        }
//        else -> {
//            super.onOptionsItemSelected(item)
//        }
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(findNavController()) || super.onOptionsItemSelected(
//            item
//        )
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}