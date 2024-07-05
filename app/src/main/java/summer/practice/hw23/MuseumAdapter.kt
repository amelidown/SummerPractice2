package summer.practice.hw23

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import summer.practice.hw23.databinding.ItemMuseumBinding
import summer.practice.hw23.Museum

class MuseumAdapter(
    private val list: List<Museum>,
    private val onClick: (Museum) -> Unit,
) : RecyclerView.Adapter<MuseumHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MuseumHolder = MuseumHolder(
        binding = ItemMuseumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onClick = onClick
    )

    override fun onBindViewHolder(holder: MuseumHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}