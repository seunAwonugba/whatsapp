package com.raywenderlich.timefighter.whatsapp_assignment

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val profile:List<Profile>,
    private val listener: OnItemClickListener
    ):
    RecyclerView.Adapter<RecyclerViewAdapter.ClassViewHolder>() {
    inner class ClassViewHolder(itemsView:View):RecyclerView.ViewHolder(itemsView),View.OnClickListener{
        private val profileImageInstance:ImageView = itemsView.findViewById(R.id.recycle_view_profile_image_id)
        private val profileNameInstance:TextView = itemsView.findViewById(R.id.recycle_view_profile_name_id)

        fun bindingFunction(profile: Profile){
            profileImageInstance.setImageResource(profile.profileImage)
            profileNameInstance.text = profile.profileName
        }

        init {
            itemsView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val inflaterVariable = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_layout,parent,false)
        return ClassViewHolder(inflaterVariable)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.bindingFunction(profile[position])
    }

    override fun getItemCount() = profile.size


}


