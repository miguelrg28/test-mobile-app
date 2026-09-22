package com.example.testpucm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testpucm.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        var adapter = android.widget.ArrayAdapter.createFromResource(
            requireContext(),
            R.array.opciones_carrera, // El nombre que le pusimos en strings.xml
            android.R.layout.simple_spinner_item // Diseño básico de Android para items
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item))
        binding.spinnerCarrera.adapter = adapter

        binding.btnGuardar.setOnClickListener {
            val nombre = binding.editTextText.text.toString()
            val matricula = binding.editTextText2.text.toString()
            val carrera = binding.spinnerCarrera.selectedItem.toString()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}