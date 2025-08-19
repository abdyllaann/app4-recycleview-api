package com.smktunas.app5_recycleview
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smktunas.app5_recycleview.adapter.BukuAdapter
import com.smktunas.app5_recycleview.model.Buku
import com.smktunas.app5_recycleview.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var rvBuku: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBuku = findViewById(R.id.rvBuku)
        rvBuku.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getBuku().enqueue(object : Callback<List<Buku>> {
            override fun onResponse(call: Call<List<Buku>>, response: Response<List<Buku>>) {
                if (response.isSuccessful) {
                    rvBuku.adapter = BukuAdapter(response.body() ?: emptyList())
                }
            }

            override fun onFailure(call: Call<List<Buku>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Gagal: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}