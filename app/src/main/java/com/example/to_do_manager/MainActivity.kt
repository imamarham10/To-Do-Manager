package com.example.to_do_manager

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*

class MainActivity : AppCompatActivity() {
    var listOfNotes = ArrayList<Note>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // add dummy data
        listOfNotes.add(Note(1,"Arham","Hello, I am Mohammad Arham Imam. I am the creator of this application. Hope you like the features and layout of this app. Do give your reviews in the comment section below."))
        listOfNotes.add(Note(2,"Imam","Hello, I am Mohammad Arham Imam. I am the creator of this application. Hope you like the features and layout of this app. Do give your reviews in the comment section below."))
        listOfNotes.add(Note(3,"Mohammad ","Hello, I am Mohammad Arham Imam. I am the creator of this application. Hope you like the features and layout of this app. Do give your reviews in the comment section below."))
        listOfNotes.add(Note(4,"saira","Hello, I am Mohammad Arham Imam. I am the creator of this application. Hope you like the features and layout of this app. Do give your reviews in the comment section below."))

        var myNotesAdapter = myAdapter(listOfNotes)
        lvNote.adapter = myNotesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note,menu)
        val sv = menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val sm = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query : String?): Boolean {
                Toast.makeText(applicationContext,query, Toast.LENGTH_LONG).show()
                //TODO search data base
                return false
            }

            override fun onQueryTextChange(query : String?): Boolean {
                TODO("Not yet implemented")
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!= null) {
            when (item.itemId) {
                R.id.menuAdd -> {
                    //goto add_note
                    var intent = Intent(this, add_note::class.java)
                    startActivity(intent)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    inner class  myAdapter:BaseAdapter {
        var listOfNote = ArrayList<Note>()
        constructor(listOfNote: ArrayList<Note>):super()
        {
            this.listOfNote = listOfNote

        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.ticket,null)
            var myNote = listOfNote[p0]
            myView.tvTitle.text = myNote.noteTitle
            myView.tvDes.text = myNote.noteDes

            return myView
        }

        override fun getItem(p0: Int): Any {
            return listOfNote[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfNote.size
        }
    }
}