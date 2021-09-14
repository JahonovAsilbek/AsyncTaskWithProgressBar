package uz.revolution.asynctaskprogressbar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import uz.revolution.asynctaskprogressbar.R
import uz.revolution.asynctaskprogressbar.databinding.ItemImageBinding

class ImageAdapter(var data: ArrayList<String>) : RecyclerView.Adapter<ImageAdapter.VH>() {

    inner class VH(var itemImageBinding: ItemImageBinding) :
        RecyclerView.ViewHolder(itemImageBinding.root) {

        fun onBind(string: String) {
            itemImageBinding.progressBar.visibility = View.VISIBLE
            Picasso.get().load(string).error(R.drawable.image)
                .into(itemImageBinding.imageView, object : Callback {
                    override fun onSuccess() {
                        itemImageBinding.progressBar.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {

                    }

                })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size
}