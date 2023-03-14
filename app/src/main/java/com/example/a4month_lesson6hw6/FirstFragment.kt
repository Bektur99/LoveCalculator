package com.example.a4month_lesson6hw6

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.a4month_lesson6hw6.databinding.FragmentFirstBinding
import com.example.a4month_lesson6hw6.remote.LoveModel
import com.example.a4month_lesson6hw6.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var utils: Utils

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
            btnCalculate.setOnClickListener {
                viewModel.getLiveLove(
                    firstName = firstEt.text.toString(),
                    secondName = secondEt.text.toString()
                ).observe(viewLifecycleOwner,
                    Observer {

                        App.appDatabase.loveDao().insert(it)

                        Log.e("ololo", "initListener: $it" )
                        findNavController().navigate(
                            R.id.resultFragment, bundleOf(
                                "model" to it
                            )
                        )
                    })
                utils.showToast(requireContext())
            }
        }
    }
}