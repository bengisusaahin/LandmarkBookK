package com.bengisusahin.landmarkbookk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bengisusahin.landmarkbookk.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        //casting
        //val selectedLandmark = intent.getSerializableExtra("landmark") as Landmark

        //val selectedLandmark = chosenLandmark

        val selectedLandmark = MySingleton.chosenLandmark

        selectedLandmark?.let {
            binding.nameText.text = it.name
            binding.countryText.text = it.country
            binding.imageView.setImageResource(it.image)
        }

    }
}