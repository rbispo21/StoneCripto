package br.com.stone.stonecripto.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.stone.stonecripto.R
import br.com.stone.stonecripto.currencyString
import br.com.stone.stonecripto.model.Transaction
import br.com.stone.stonecripto.model.TransactionType
import io.realm.RealmResults
import kotlinx.android.synthetic.main.item_transaction.view.*

class HistoryAdapter(val transactions: RealmResults<Transaction>): RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.item_transaction,
            parent, false)
        return HistoryViewHolder(v)
    }

    override fun getItemCount(): Int = transactions.count()

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.itemView.txtType.text = transaction?.type
        holder.itemView.txtPrice.text = transaction?.priceTotal?.currencyString()
        holder.itemView.txtCoin.text = "${transaction?.amount} ${transaction?.typeCoin}"

        transaction?.type?.let {
            if (it == TransactionType.BUY.name) {
                holder.itemView.constraintCard.setBackgroundResource(R.color.colorBackgroundBuy)
            } else {
                holder.itemView.constraintCard.setBackgroundResource(R.color.colorBackgroundSell)
            }
        }
    }
}

class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)