package com.ivangarzab.animatedvectoricon

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.ivangarzab.animatedvectoricon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animatedIconArrowLeft.apply {
            setOnClickListener {
                animateImageView(binding.animatedIconArrowLeft)
            }
        }
    }

    private fun animateImageView(imageView: ImageView) =
        imageView.drawable.apply {
            when (this) {
                is AnimatedVectorDrawableCompat -> this.start()
                is AnimatedVectorDrawable -> this.start()
                else -> { /* not an animated icon */ }
            }
        }
}