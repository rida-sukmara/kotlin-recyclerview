package com.ridasukmara.asynclistdiffer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ridasukmara.asynclistdiffer.R
import com.ridasukmara.asynclistdiffer.adapter.recyclerview.RecyclerViewAdapter
import com.ridasukmara.asynclistdiffer.utils.UserProvider

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var btnRandom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
    }

    override fun onStart() {
        super.onStart()
        setupRv()
    }

    private fun setupRv() {
        val users = UserProvider.randomUser()

        val adapter = RecyclerViewAdapter(items = users)

        recyclerView = findViewById(R.id.rv_recyclerview)
        recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = GridLayoutManager(this@RecyclerViewActivity, 6, GridLayoutManager.VERTICAL, false)
        }

        btnRandom = findViewById<Button>(R.id.btnRandom)

        btnRandom.setOnClickListener {
            adapter.items = UserProvider.randomUser()
            adapter.notifyDataSetChanged()
        }
    }
}
