package com.ridasukmara.asynclistdiffer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ridasukmara.asynclistdiffer.ui.AsyncListDifferActivity
import com.ridasukmara.asynclistdiffer.ui.RecyclerViewActivity

lateinit var btnRecyclerView: Button
lateinit var btnAsyncDiff: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        btnRecyclerView = findViewById(R.id.btnRecyclerView)
        btnAsyncDiff = findViewById(R.id.btnDiffUtil)

        setupButtonActions()
    }

    fun setupButtonActions() {
        btnRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        btnAsyncDiff.setOnClickListener {
            startActivity(Intent(this, AsyncListDifferActivity::class.java))
        }
    }
}
