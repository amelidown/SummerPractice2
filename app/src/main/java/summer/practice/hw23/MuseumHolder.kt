package summer.practice.hw23

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import summer.practice.hw23.databinding.FragmentProfileBinding
import summer.practice.hw23.databinding.ItemMuseumBinding

    class MuseumHolder(
        private val binding: ItemMuseumBinding,
        private val onClick: (Museum) -> Unit,
    ) : ViewHolder(binding.root) {

        fun onBind(club: Museum) {
            binding.run {
                tvNameMuseum.text = club.name
                tvNameCity.text = club.city

                Glide.with(itemView.context)
                    .load(club.url)
                    .into(ivImage)
                root.setOnClickListener {
                    onClick(club)
                }
            }
        }
    }

