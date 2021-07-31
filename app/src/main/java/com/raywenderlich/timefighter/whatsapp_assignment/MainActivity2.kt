package com.raywenderlich.timefighter.whatsapp_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var instanceOfActivity1ProfileImage : ImageView
    lateinit var instanceOfActivity1ProfileName : TextView
    lateinit var instanceOfEmail:TextView
    lateinit var instanceOfPhoneNumber:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        instanceOfActivity1ProfileImage = findViewById(R.id.recycle_view_profile_image_id)
        instanceOfActivity1ProfileName = findViewById(R.id.recycle_view_profile_name_id)
        instanceOfEmail = findViewById(R.id.phoneNumberTextViewId)
        instanceOfPhoneNumber = findViewById(R.id.emailTextViewId)



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

    }
}