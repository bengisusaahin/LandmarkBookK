package com.bengisusahin.landmarkbookk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.bengisusahin.landmarkbookk.databinding.ActivityDetailsBinding
import com.bengisusahin.landmarkbookk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        landmarkList = ArrayList<Landmark>()

        //data
        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa)
        val colosseum = Landmark("Colosseum", "Italy", R.drawable.coliseum)
        val eiffel = Landmark("Eiffel", "France", R.drawable.eiffel)
        val londonBridge = Landmark("LondonBridge", "UK", R.drawable.london)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)

        //Adapter : Amacı Layout & Data yı birlestirmek

        //Mapping
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            landmarkList.map{landmark -> landmark.name }
        )
    // simple_list_item_1 -> sadece eger textview gösterceksek
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->
            val intent = Intent(MainActivity@this, DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(position))
            //landmarkList.get(position)
            startActivity(intent)
        }
    }
}