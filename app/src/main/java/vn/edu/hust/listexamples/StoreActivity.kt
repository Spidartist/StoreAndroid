package vn.edu.hust.listexamples

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StoreActivity : AppCompatActivity(), RVStoreItemAdapter.ItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        val items = arrayListOf<OneApp>()
        repeat(28) {
            val index = it + 1
            items.add(OneApp(
                "Item $index",
                resources.getIdentifier("thumb$index", "drawable", packageName)
            ))
        }

        val adapter = RVStoreItemAdapter(items, this)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

    }

    override fun ItemClick(position: Int) {
        Log.v("TAG", "Selected position: $position")
    }
}