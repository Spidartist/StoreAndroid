package vn.edu.hust.listexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVStoreItemAdapter(
    val items: ArrayList<OneApp>,
    val listener: ItemClickListener?
) : RecyclerView.Adapter<RVStoreItemAdapter.RVItemViewHolder>() {
    class RVItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
        val imageThumb = itemView.findViewById<ImageView>(R.id.image_thumb)
        val appName = itemView.findViewById<TextView>(R.id.app_name)
        val rating = itemView.findViewById<TextView>(R.id.rating)

        init {
            itemView.setOnClickListener {
                listener?.ItemClick(adapterPosition)
            }
        }
    }


    interface ItemClickListener {
        fun ItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.store_single_item, parent, false)

        return RVItemViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        holder.imageThumb.setImageResource(items[position].imageThumb)
        holder.appName.text = items[position].name
        holder.rating.text = items[position].rating.toString()
    }
}