package com.example.contacts.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.Contact


class ContactAdapter(var items: List<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ContactHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

        private val phone = itemView.findViewById<TextView>(R.id.phone)
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val photo = itemView.findViewById<ImageView>(R.id.photo)

        fun bind(item: Contact) {
            phone.text = item.phoneNumber
            name.text = item.name
            photo.setImageResource(R.mipmap.ic_launcher_round)
        }

    }


}