package com.example.pokemonsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pokemonsproject.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListenerForElement(binding.layout1, 1)
        setOnClickListenerForElement(binding.layout2, 2)
        setOnClickListenerForElement(binding.layout3, 3)
    }

    fun setOnClickListenerForElement(element: View, id: Int){
        element.setOnClickListener{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }
}
