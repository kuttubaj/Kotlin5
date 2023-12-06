package com.example.kotlin5

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.kotlin5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.ivCountry.setImageURI(it)
        Car.galleryState = binding.ivCountry.drawable.toBitmap()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivCountry.setImageBitmap(Car.galleryState)
        binding.tvCounter.text = Car.count.toString()

        chooseImageFromGallery()
        setCouter()
    }

    private fun chooseImageFromGallery() = with(binding) {
        ivCountry.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    private fun setCouter() = with(binding) {
        btnPlus.setOnClickListener {
            if (Car.count >= 10) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
            tvCounter.text = (++Car.count).toString()
        }
        btnNegative.setOnClickListener {
            if (Car.count > 0) {
                tvCounter.text = (--Car.count).toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(COUNT_KEY, Car.count)
        if (Car.galleryState != null) {
            outState.putParcelable(GALLERY_KEY, Car.galleryState!!)
            Log.e("TAG", "onSaveInstanceState: Save data")
        }
    }

    companion object {
        const val COUNT_KEY = "count"
        const val GALLERY_KEY = "galley"
    }
}