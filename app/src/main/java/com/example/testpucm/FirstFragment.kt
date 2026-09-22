package com.example.testpucm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testpucm.databinding.FragmentFirstBinding
import android.app.AlertDialog

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        AlertDialog.Builder(requireContext())
            .setTitle("Prueba")
            .setMessage("Probando...")
            .setPositiveButton("Nitido"){ dialog, _ ->
            dialog.dismiss()
        }
            .setNegativeButton("Quitar"){dialog, _ ->
                dialog.dismiss()
            }
            .show()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = requireActivity().getSharedPreferences("DatosEstudiante", android.content.Context.MODE_PRIVATE)

        val nameSaved = sharedPref.getString("key_nombre", "No hay datos guardados")
        val matriculaSaved = sharedPref.getString("key_matricula", "No hay datos guardados")
        val carreraSaved = sharedPref.getString("key_carrera", "No hay datos guardados")

        binding.tvName.text = nameSaved
        binding.tvMatricula.text = "Matrícula: $matriculaSaved"
        binding.tvCarrera.text = "Carrera: $carreraSaved"

        if(nameSaved == "No hay datos guardados"){
            binding.btnEdit.text = getString(R.string.btn_add_txt)
        } else {
            binding.btnEdit.text = getString(R.string.btn_edit_txt)
        }

        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}