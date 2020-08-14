package com.example.to_do_manager

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_note.*

class add_note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
    }
    fun  buAdd(view:View){
        var dbManager=DbManager(this)

        var values= ContentValues()
        values.put("Title",etTitle.text.toString())
        values.put("Description",etDes.text.toString())

        val ID = dbManager.Insert(values)
        if (ID > 0) {
            Toast.makeText(this, " note is added", Toast.LENGTH_LONG).show()
            finish()
        } else {
            Toast.makeText(this, " cannot add note ", Toast.LENGTH_LONG).show()
        }
        }
}