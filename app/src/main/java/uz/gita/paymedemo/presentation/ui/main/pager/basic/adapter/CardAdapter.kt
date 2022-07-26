package uz.gita.paymedemo.presentation.ui.main.pager.basic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.response.main.basic.Basic
import uz.gita.paymedemo.databinding.MyCardListItemBinding

class CardAdapter(val context: Context) :
    ListAdapter<Basic.CardAddResponse, CardAdapter.Holder>(BasicCallBack) {
    private var onclickItemListener: ((Basic.CardAddResponse) -> Unit)? = null
    lateinit var shared: SharedPrefToken
    private val cardCodeNew = StringBuilder()

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

    inner class Holder(private val binding: MyCardListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onclickItemListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun bind(): Basic.CardAddResponse = with(binding) {
            shared = SharedPrefToken(context)
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
                cardName.text = name
                if (pan.startsWith("8600"))
                    cardLogo.setImageResource(R.drawable.ic_uzcard_logo)
                when (shared.language) {
                    "uz" -> sumCard.text = "so'm"
                    "ru" -> sumCard.text = "сум"
                    else -> sumCard.text = "sum"
                }
                userName.text = owner
                cardNumberPan.text =
                    pan.substring(0, 4) + " " + pan.substring(4, 8) + " " + pan.substring(
                        8,
                        12
                    ) + " " + pan.substring(12, 16)
                cardPeriod.text = expiredAt.substring(0, 2) + "/" + expiredAt.substring(2, 4)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(
            MyCardListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    fun setOnclickItemListener(block: (Basic.CardAddResponse) -> Unit) {
        onclickItemListener = block
    }
}