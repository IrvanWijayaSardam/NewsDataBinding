package com.aminivan.newsdatabinding

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aminivan.newsdatabinding.databinding.FragmentMainBinding
import java.util.*
import kotlin.collections.ArrayList


class FragmentMain : Fragment() {

    lateinit var binding : FragmentMainBinding
    private lateinit var tempArray: ArrayList<News>
    private lateinit var newArrayList : ArrayList<News>
    private lateinit var newRecyleView : RecyclerView
    private lateinit var arrayWords: ArrayList<News>
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
        setHasOptionsMenu(true)

        newArrayList = arrayListOf()
        tempArray = arrayListOf()

        arrayWords = arrayListOf(
            News("Neon Genesis Evangelion Creator Discusses Whether the Anime Is Finished","17/08/2022",R.drawable.neongenesis,"Neon Genesis Evangelion is a name most anime fans know by heart. Even if you haven't seen the mech series, Hideaki Anno birthed a truly special story when the anime went live decades ago. Evangelion is now considered one of the greatest sci-fi series in television to date, and its most recent adaptation came to life last year after a long, long wait. But if you are waiting for the anime to announce a new project, well – you might want to reconsider the choice.\n" +
                    "As it turns out, Anno is pretty well and done with Evangelion. After finishing the anime's latest film run, the creator did a Q&A recently and confirmed he is really done with the hit series A fan asked Anno if he is truly finished with the anime, and the creator made it clear that was the case. \"This is the third time I've finished it, so I think that's enough,\" he shared. Of course, fans of Evangelion know that's the truth. Anno has come back to the franchise time and again. After finishing the main TV series in 1996, the franchise put out The End of Evangelion in 1997. The anime then returned under Anno's supervision with the Rebuild of Evangelion films. The film run began in 2007 and finished last year at long last. The Rebuild of Evangelion run reboots the original TV series while altering some surprising plot lines and endings. So if you have not checked out the movies, you should do so ASAP If you have not watched Neon Genesis Evangelion, you can find it streaming on Netflix as well as Funimation.","Irvan Wijaya"),
            News("Ferdi Wijaya ","17/08/2022",R.drawable.ic_launcher_background,"Reka ulang telah dilaksanakan , dan jawaban dicopot","Irvan Wijaya"),
        )


        newRecyleView = requireView().findViewById<RecyclerView>(R.id.rvMain)
        newArrayList.addAll(arrayWords)
        tempArray.addAll(arrayWords)

        newRecyleView.layoutManager =  LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        newRecyleView.adapter =  AdapterNews(tempArray)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val item = menu.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(newText: String?): Boolean {
                tempArray.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    newArrayList.forEach{
                        if (it.title.toLowerCase(Locale.getDefault()).contains(searchText)){
                            Toast.makeText(context, "${searchText}", Toast.LENGTH_SHORT).show()
                            tempArray.add(it)
                        }
                    }
                    newRecyleView.adapter!!.notifyDataSetChanged()
                }
                else{
                    tempArray.clear()
                    tempArray.addAll(newArrayList)
                    newRecyleView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArray.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    newArrayList.forEach{
                        if (it.title.toLowerCase(Locale.getDefault()).contains(searchText)){
                            tempArray.add(it)
                        }
                    }
                    newRecyleView.adapter!!.notifyDataSetChanged()
                }
                else{
                    tempArray.clear()
                    tempArray.addAll(newArrayList)
                    newRecyleView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })
        super.onCreateOptionsMenu(menu, inflater)
    }

}