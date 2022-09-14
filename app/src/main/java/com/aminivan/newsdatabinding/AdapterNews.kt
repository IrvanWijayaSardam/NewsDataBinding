package com.aminivan.newsdatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aminivan.newsdatabinding.databinding.ItemNewsBinding
import kotlin.properties.Delegates

class AdapterNews(var listNews: ArrayList<News>): RecyclerView.Adapter<AdapterNews.ViewHolder>() {
    lateinit var title: String
    lateinit var date: String
    var image by Delegates.notNull<Int>()
    lateinit var writer: String
    lateinit var content: String

    class ViewHolder(val binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root) {
        fun databind(itemData : News){
            binding.datanews = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(listNews[position])
        title = listNews[position].title
        date = listNews[position].date
        image = listNews[position].image
        writer = listNews[position].writer
        content = listNews[position].content
        holder.binding.cvItem.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View?) {
                var bundle = Bundle()
                bundle.putString("title",title)
                bundle.putString("date",date)
                bundle.putInt("image",image)
                bundle.putString("writer",writer)
                bundle.putString("content",content)

                Navigation.findNavController(holder.itemView).navigate(R.id.action_fragmentMain_to_fragmentDetail,bundle)
            }
        })
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}