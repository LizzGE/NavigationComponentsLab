package com.cursosant.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.cursosant.navigationcomponents.databinding.FragmentPrimerBinding

class PrimerFragment : Fragment(R.layout.fragment_primer) {

    private lateinit var binding: FragmentPrimerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPrimerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.btnNavegar
        val resultado = binding.txtOutput

        setFragmentResultListener("requestKey") { key , bundle ->
            val result = bundle.getString("bundleKey")
            resultado.text = result
        }

        button.setOnClickListener {
            findNavController().navigate(R.id.action_primerFragment_to_segundoFragment)
        }
    }
}