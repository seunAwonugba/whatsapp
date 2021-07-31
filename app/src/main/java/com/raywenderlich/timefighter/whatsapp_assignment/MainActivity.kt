package com.raywenderlich.timefighter.whatsapp_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnItemClickListener {

    /**
     * Create an instance of recycleView
     */
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fullProfile = listOf(
            Profile("Loretta M. Hawthorne",R.drawable.ali_pazani_b4hzxqfzuoo_unsplash),
            Profile("Lakisha T. Huang",R.drawable.brooke_cagle_otweoxmkdka_unsplash),
            Profile("Sarita A. Puckett",R.drawable.gean_montoya_cedwdchuusk_unsplash),
            Profile("Gracious Adebayo",R.drawable.julian_wan_wnolnjo7ts8_unsplash),
            Profile("Loretta M. Hawthorne",R.drawable.alex_suprun_zhvm3xiohoe_unsplash),

        )


        val recyclerViewAdapter = RecyclerViewAdapter(fullProfile,this)

        recyclerView = findViewById(R.id.recyclerViewId)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
       val intent = Intent(this,MainActivity2::class.java)
//        intent.putExtra("image", )
        startActivity(intent)
    }
}