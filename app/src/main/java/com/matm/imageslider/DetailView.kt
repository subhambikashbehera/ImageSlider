package com.matm.imageslider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class DetailView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)
        this.supportActionBar?.hide()

        val arrayList =ArrayList<String>()

        repeat(20){
            arrayList.add("ADDING")
        }

        val actorAdapter = ActorsAdapter()
        val promotionalVideoAdapter  =PromotionalVideoAdapter()
        val recyclerView1=findViewById<RecyclerView>(R.id.promotionalVideoRecyclerView)
        val recyclerView2=findViewById<RecyclerView>(R.id.personRecyclerView)
        recyclerView1.adapter = promotionalVideoAdapter
        recyclerView2.adapter = actorAdapter

        actorAdapter.differ.submitList(arrayList)
        promotionalVideoAdapter.differ.submitList(arrayList)

        val button = findViewById<Button>(R.id.payNow)

        button.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }





    }



}