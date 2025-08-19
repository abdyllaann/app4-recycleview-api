package com.smktunas.app5_recycleview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_buku)

        val tvJudul: TextView = findViewById(R.id.tvJudulDetail)
        val tvPenulis: TextView = findViewById(R.id.tvPenulisDetail)
        val tvTahun: TextView = findViewById(R.id.tvTahunDetail)
        val ivCover: ImageView = findViewById(R.id.ivCoverDetail)

        tvJudul.text = intent.getStringExtra("judul")
        tvPenulis.text = intent.getStringExtra("penulis")
        tvTahun.text = intent.getStringExtra("tahun")

        Glide.with(this)
            .load(intent.getStringExtra("cover"))
            .into(ivCover)
    }
}