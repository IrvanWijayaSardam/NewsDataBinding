package com.aminivan.newsdatabinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.aminivan.newsdatabinding.databinding.FragmentMainBinding


class FragmentMain : Fragment() {

    lateinit var binding : FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_main, container, false)

        binding = FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData()
    }

    fun showData(){
        var listNews = arrayListOf(
            News("Ferdi Rambo ","17/08/2022",R.drawable.ic_launcher_background,"Reka ulang telah dilaksanakan , dan jawaban dicopot","Irvan Wijaya"),
            News("Ferdi Wijaya ","17/08/2022",R.drawable.ic_launcher_background,"Reka ulang telah dilaksanakan , dan jawaban dicopot","Irvan Wijaya"),
        )

        binding.rvMain.adapter = AdapterNews(listNews)
        binding.rvMain.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
    }

}