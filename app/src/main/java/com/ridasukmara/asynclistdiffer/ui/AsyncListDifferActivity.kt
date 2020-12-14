package com.ridasukmara.asynclistdiffer.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ridasukmara.asynclistdiffer.R
import com.ridasukmara.asynclistdiffer.adapter.asynclist.AsyncListAdapter
import com.ridasukmara.asynclistdiffer.utils.UserProvider

class AsyncListDifferActivity : AppCompatActivity() {

    lateinit var rvAsync: RecyclerView
    lateinit var btnRandom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_list_differ)
    }

    override fun onStart() {
        super.onStart()
        setupRv()
    }

    private fun setupRv() {
        rvAsync = findViewById(R.id.rv_async)
        btnRandom = findViewById(R.id.btnRandomAsync)


        val adapter = AsyncListAdapter()
        val layoutManager = GridLayoutManager(this@AsyncListDifferActivity, 6, GridLayoutManager.VERTICAL, false)

        adapter.submitList(UserProvider.randomUser())

        rvAsync.apply {
            this.layoutManager  = layoutManager
            this.adapter        = adapter
            hasFixedSize()
        }

        btnRandom.setOnClickListener {
            adapter.submitList(UserProvider.randomUser())
        }
    }
}
