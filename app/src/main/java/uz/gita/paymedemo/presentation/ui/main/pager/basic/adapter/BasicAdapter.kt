package uz.gita.paymedemo.presentation.ui.main.pager.basic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.remote.response.main.basic.Basic
import uz.gita.paymedemo.databinding.MyCardItemBinding

class BasicAdapter : ListAdapter<Basic.CardAddResponse, BasicAdapter.Holder>(BasicCallBack) {

    object BasicCallBack : DiffUtil.ItemCallback<Basic.CardAddResponse>() {
        override fun areItemsTheSame(
            oldItem: Basic.CardAddResponse,
            newItem: Basic.CardAddResponse
        ): Boolean =
            newItem.cardId == oldItem.cardId

        override fun areContentsTheSame(
            oldItem: Basic.CardAddResponse,
            newItem: Basic.CardAddResponse
        ): Boolean =
            newItem == oldItem
    }

    inner class Holder(private val binding: MyCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(): Basic.CardAddResponse = with(binding) {
            getItem(absoluteAdapterPosition).apply {
                cardAllTotal.text =
                    amount.toString().substring(0, 3) + " " + amount.toString()
                        .substring(3, amount.toString().length)
                when (theme) {
                    0 -> {
                        cardBgImage.setBackgroundResource(R.drawable.card_bg_1)
                    }
                    1 -> {
                        cardBgImage.setBackgroundResource(R.drawable.card_bg_2)
                    }
                    2 -> {
                        cardBgImage.setBackgroundResource(R.drawable.card_bg_3)
                    }
                    3 -> {
                        cardBgImage.setBackgroundResource(R.drawable.card_bg_4)
                    }
                    4 -> {
                        cardBgImage.setBackgroundResource(R.drawable.card_bg_5)
                    }
                    5 -> {
                        cardBgImage.setBackgroundResource(R.drawable.card_bg_6)
                    }
                    else -> {
                        cardBgImage.setBackgroundResource(R.drawable.card_bg_1)
                    }
                }
                binding.cardName.text = name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(
            MyCardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }
}