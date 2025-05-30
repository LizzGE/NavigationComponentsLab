package com.cursosant.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cursosant.navigationcomponents.databinding.FragmentSegundoBinding
import androidx.core.net.toUri


class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private lateinit var binding: FragmentSegundoBinding
    private var nombre : String? = ""
    private var edad : Int? = 0

    /*'navArgs' es para obtener los argumentos enviados desde el fragmento anterior,
     esto me permite acceder facilmente a 'nombre' y 'edad' sin usar Bundle manualmente*/
    private val args: SegundoFragmentArgs by navArgs()

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
    //Asignamos los argumentos recibidos a variables locales para usarlos en el fragmento
        nombre = args.nombre
        edad = args.edad
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = binding.txtOutput
        val button = binding.btnEnviarDatos

        button.setOnClickListener {
            val result = "Resultado"
            setFragmentResult("requestKey", bundleOf("bundlekKey" to result))
            findNavController().navigate("navigation://card".toUri()) // Navegamos al destino usando un deep link interno (URI) definido en el nav_graph

        }

        text.text = "$nombre, $edad"
    }
}