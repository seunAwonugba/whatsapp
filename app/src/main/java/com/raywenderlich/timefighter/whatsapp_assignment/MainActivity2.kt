package com.raywenderlich.timefighter.whatsapp_assignment

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity2 : AppCompatActivity() {
    lateinit var instanceOfActivity1ProfileImage: ImageView
    lateinit var instanceOfActivity1ProfileName: TextView
    lateinit var instanceOfEmail: TextView
    lateinit var instanceOfPhoneNumber: TextView
    lateinit var instanceOfPhoneIcon: ImageView
    var requestPhoneCall = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = "Activity1"


        instanceOfActivity1ProfileImage = findViewById(R.id.recycle_view_profile_image_id)
        instanceOfActivity1ProfileName = findViewById(R.id.recycle_view_profile_name_id)
        instanceOfEmail = findViewById(R.id.phoneNumberTextViewId)
        instanceOfPhoneNumber = findViewById(R.id.emailTextViewId)
        instanceOfPhoneIcon = findViewById(R.id.phoneId)


        var putPicture = intent.extras?.getInt("putExtraProfileImage")
        var putText = intent.getStringExtra("putExtraProfileName")
        var putPhoneNumber = intent.getStringExtra("putExtraProfilePhoneNumber")
        var putEmail = intent.getStringExtra("putExtraProfileEmail")

        //set value to view
        if (putPicture != null) {
            instanceOfActivity1ProfileImage.setImageResource(putPicture)
        }
        instanceOfActivity1ProfileName.text = putText
        instanceOfPhoneNumber.text = putPhoneNumber
        instanceOfEmail.text = putEmail

        instanceOfPhoneIcon.setOnClickListener {
            checkForPhonePermission()
        }

    }


    private fun checkForPhonePermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), requestPhoneCall);
        }
        else {
            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:" + instanceOfPhoneNumber.text.toString())
            startActivity(i)
        }
    }
}