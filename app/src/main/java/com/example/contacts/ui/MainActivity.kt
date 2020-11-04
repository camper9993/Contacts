package com.example.contacts.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.ui.adapters.ContactAdapter
import com.example.contacts.data.Contact
import com.example.contacts.data.fetchAllContacts


class MainActivity : AppCompatActivity() {

    lateinit var rv : RecyclerView
    lateinit var contacts : List<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 1)
        if (checkPermission()) {
            setContentView(R.layout.activity_main)
            contacts = applicationContext.fetchAllContacts()
            initRecyclerView()
            val text = resources.getText(R.string.info)
            Toast.makeText(this,"${contacts.size} " + text, Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this, "Нет доступа!!!", Toast.LENGTH_LONG).show()
        }
    }

    private fun initRecyclerView() {
        val llm = LinearLayoutManager(this)
        val adapter = ContactAdapter(contacts)
        llm.orientation = LinearLayoutManager.VERTICAL
        rv = findViewById(R.id.my_recycler_view)
        rv.layoutManager = llm
        rv.adapter = adapter
    }

    private fun checkPermission() : Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
    }
}