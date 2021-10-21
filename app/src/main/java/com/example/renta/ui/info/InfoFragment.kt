package com.example.renta.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.renta.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    companion object {
        private const val TITLE = "Тестовое задание для Rentateam"
    }

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = TITLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}