package com.raywenderlich.timefighter.whatsapp_assignment

import android.provider.ContactsContract

data class Profile(
    var profileName:String,
    var profileImage:Int,
    var profilePhoneNumber:String,
    var profileEmail: String
)