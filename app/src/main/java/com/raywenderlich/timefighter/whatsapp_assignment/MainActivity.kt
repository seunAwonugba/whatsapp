package com.raywenderlich.timefighter.whatsapp_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.app.ActivityOptionsCompat as AppActivityOptionsCompat

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnItemClickListener {

    /**
     * Create an instance of recycleView, and data class in an array form from adapter
     */
    lateinit var recyclerView: RecyclerView
    lateinit var fullProfile: List<Profile>
//    lateinit var instanceOfBackArrow:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        instanceOfBackArrow = findViewById(R.id.backArrowId)
        setTitle("Activity1")


        fullProfile = listOf(
            Profile("Loretta M. Hawthorne",R.drawable.ali_pazani_b4hzxqfzuoo_unsplash,
            "(919)-516-0844","loretta@example.com"),
            Profile("Lakisha T. Huang",R.drawable.brooke_cagle_otweoxmkdka_unsplash,
            "(220)-450-1537", "lakisha@example.com"),
            Profile("Sarita A. Puckett",R.drawable.gean_montoya_cedwdchuusk_unsplash,
            "(506)-734-9414", "sarita@example.com"),
            Profile("Gracious Adebayo",R.drawable.julian_wan_wnolnjo7ts8_unsplash,
            "(225)-836-7552", "gracious@example.com"),
            Profile("Christine Gonzales",R.drawable.alex_suprun_zhvm3xiohoe_unsplash,
            "(305)-937-8165", "christine@example.com"),
        )

        val recyclerViewAdapter = RecyclerViewAdapter(fullProfile,this)
        recyclerView = findViewById(R.id.recyclerViewId)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


//        instanceOfBackArrow.setOnClickListener{goBack()}

    }
//
//    private fun goBack(){
//        val grabIntent = Intent(this, MainActivity::class.java)
//        startActivity(grabIntent)
//    }


    override fun onItemClick(position: Int) {
       val intent = Intent(this,MainActivity2::class.java)
        intent.putExtra("putExtraProfileImage", fullProfile[position].profileImage)
        intent.putExtra("putExtraProfileName", fullProfile[position].profileName)
        intent.putExtra("putExtraProfilePhoneNumber", fullProfile[position].profilePhoneNumber)
        intent.putExtra("putExtraProfileEmail", fullProfile[position].profileEmail)
        startActivity(intent)
    }
}