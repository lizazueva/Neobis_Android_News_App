package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.databinding.FragmentSaveBinding
import com.example.myapplication.model.News
import com.example.myapplication.viewModel.MyViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    lateinit var viewModelNewsDetailFragment: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelNewsDetailFragment = (activity as MainActivity).myViewModel

         var news = arguments?.getSerializable("news") as News
        binding.webView.loadUrl(news.url)

        binding.imageBack.setOnClickListener{
            findNavController().navigate(R.id.action_detailFragment_to_newsFragment)
        }

        binding.floating.setOnClickListener{
            if (news.isSaved){
                viewModelNewsDetailFragment.delete(news)
                Toast.makeText(requireContext(), "News deleted!", Toast.LENGTH_SHORT).show()
            } else {
                viewModelNewsDetailFragment.save(news)
                news.isSaved = true
                Toast.makeText(requireContext(), "News saved!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}