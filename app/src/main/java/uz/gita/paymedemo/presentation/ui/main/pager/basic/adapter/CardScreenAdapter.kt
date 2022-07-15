package uz.gita.paymedemo.presentation.ui.main.pager.basic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.paymedemo.data.common.models.ThemeModel
import uz.gita.paymedemo.databinding.CardColorItemBinding

class CardScreenAdapter :
    ListAdapter<ThemeModel, CardScreenAdapter.Holder>(CardCallBack) {
    private var onclickItemListener: ((Int) -> Unit)? = null

    object CardCallBack : DiffUtil.ItemCallback<ThemeModel>() {
        override fun areItemsTheSame(
            oldItem: ThemeModel,
            newItem: ThemeModel
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ThemeModel,
            newItem: ThemeModel
        ): Boolean = oldItem == newItem

    }

    inner class Holder(private val binding: CardColorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onclickItemListener?.invoke(absoluteAdapterPosition)
            }
        }

        fun bind() {
            getItem(absoluteAdapterPosition).apply {
                binding.color.setBackgroundResource(color)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(
            CardColorItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    fun setOnclickItemListener(block: (Int) -> Unit) {
        onclickItemListener = block
    }
}