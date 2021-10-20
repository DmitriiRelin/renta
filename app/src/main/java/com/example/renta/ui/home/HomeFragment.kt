package com.example.renta.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.renta.App
import com.example.renta.LoadingResult
import com.example.renta.databinding.FragmentHomeBinding
import com.example.renta.ui.home.RV.HomeAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeFragment : Fragment() {


    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory

    val viewModel: HomeViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var disposable1: Disposable? = null

    private val adapter = HomeAdapter { movie ->

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        disposable1 = viewModel.getUserList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                when (result) {
                    is LoadingResult.Success -> {
                        binding.isFromCache.text = result.isFromCache.toString()
                        if (result.data.isNotEmpty()) {
                            adapter.usersList = result.data
                            binding.emptyList.visibility = View.GONE
                        } else
                            binding.emptyList.visibility = View.VISIBLE
                    }
                    is LoadingResult.Loading -> {}

                }
            }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}