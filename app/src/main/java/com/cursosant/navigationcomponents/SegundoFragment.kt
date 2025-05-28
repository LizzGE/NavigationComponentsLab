package com.cursosant.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.cursosant.navigationcomponents.databinding.FragmentSegundoBinding


class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private lateinit var binding: FragmentSegundoBinding
    private var nombre : String? = ""
    private var edad : Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSegundoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {bundle ->
            nombre = bundle.getString(MI_NOMBRE)
            edad = bundle.getInt(MI_EDAD)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = binding.txtOutput
        val button = binding.btnEnviarDatos

        button.setOnClickListener {
            val result = "Resultado"
            setFragmentResult("requestKey", bundleOf("bundlekKey" to result))
        }

        text.text = "$nombre, $edad"

    }

    companion object {
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        fun newInstance(nombre : String, edad : Int) = SegundoFragment().apply {
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }
    }

}