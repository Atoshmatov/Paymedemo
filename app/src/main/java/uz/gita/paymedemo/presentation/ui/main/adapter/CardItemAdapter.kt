package uz.gita.paymedemo.presentation.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.paymedemo.data.common.models.BottomCardModel
import uz.gita.paymedemo.databinding.CardDialogItemBinding

class CardItemAdapter : ListAdapter<BottomCardModel, CardItemAdapter.ViewHolder>(CardItemCallBack) {
    inner class ViewHolder(private val binding: CardDialogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(): BottomCardModel = with(binding) {
            getItem(absoluteAdapterPosition).apply {
                imageLink.setBackgroundResource(image)
                textLink.setText(title)
            }
        }

    }

    object CardItemCallBack : DiffUtil.ItemCallback<BottomCardModel>() {
        override fun areItemsTheSame(
            oldItem: BottomCardModel,
            newItem: BottomCardModel
        ): Boolean = oldItem == newItem


        override fun areContentsTheSame(
            oldItem: BottomCardModel,
            newItem: BottomCardModel
        ): Boolean = oldItem == newItem


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        CardDialogItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }
}