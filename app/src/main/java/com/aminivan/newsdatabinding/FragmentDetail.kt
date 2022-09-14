package com.aminivan.newsdatabinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.aminivan.newsdatabinding.databinding.FragmentDetailBinding
import com.aminivan.newsdatabinding.databinding.FragmentMainBinding

class FragmentDetail : Fragment() {

    lateinit var binding : FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()

    }
    fun getArgs(){
        var title = arguments?.getString("title")
        var date = arguments?.getString("date")
        var image = arguments?.getInt("image")
        var writer = arguments?.getString("writer")
        var content = arguments?.getString("content")
        Toast.makeText(context, "${title}", Toast.LENGTH_SHORT).show()
        binding.tvTitleDetail.text = title
        binding.tvDate.text = date
        binding.ivDetail.setImageResource(image!!)
        binding.tvWriterDetail.text = writer
        binding.tvContent.text = content
        writer?.let { News(title!!,date!!,image!!,content!!, it) }?.let { detailNews(it) }
    }
    fun detailNews(listNews: News){
        binding.detailnews = listNews
    }

}