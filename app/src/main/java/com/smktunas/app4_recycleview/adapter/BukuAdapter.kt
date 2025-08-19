package com.smktunas.app4_recycleview.adapter

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smktunas.app4_recycleview.R
import com.smktunas.app4_recycleview.model.Buku
import com.smktunas.app4_recycleview.DetailActivity

class BukuAdapter(
    private val listBuku: List<Buku>) :
    RecyclerView.Adapter<BukuAdapter.BukuViewHolder>() {
    override fun getItemCount(): Int = listBuku.size
    class BukuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvJudul: TextView = itemView.findViewById(R.id.tvJudul)
        val tvPenulis: TextView = itemView.findViewById(R.id.tvPenulis)
        val ivCover: ImageView = itemView.findViewById(R.id.ivCover)
        val tvTahun: TextView = itemView.findViewById(R.id.tvTahun)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_buku, parent, false)
        return BukuViewHolder(view)
    }

    override fun onBindViewHolder(holder: BukuViewHolder, position: Int) {
        val buku = listBuku[position]
        holder.tvJudul.text = buku.judul
        holder.tvPenulis.text = buku.penulis
        holder.tvTahun.text = buku.tahun

        Glide.with(holder.itemView.context)
            .load(buku.cover)
            .into(holder.ivCover)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            AlertDialog.Builder(context)
                .setTitle("Pilih Buku?")
                .setMessage("Apakah kamu ingin membuka detail buku \"${buku.judul}\"?")
                .setPositiveButton("Ya") { dialog, _ ->
                    Toast.makeText(context, "Kamu Membuka: ${buku.judul}", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("judul", buku.judul)
                        putExtra("penulis", buku.penulis)
                        putExtra("tahun", buku.tahun)
                        putExtra("cover", buku.cover)
                    }
                    context.startActivity(intent)
                    dialog.dismiss()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

}