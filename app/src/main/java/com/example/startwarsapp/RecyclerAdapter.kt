package com.example.startwarsapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startwarsapp.model.entity.FullInfoCard
import com.example.startwarsapp.model.entity.InfoPageAndResult


class RecyclerAdapter(
    cardsList: List<FullInfoCard>,
    context: Context,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var cardsList:List<FullInfoCard>
    private var context:Context?= context

    init {
    this.cardsList = cardsList
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var layoutView:View = LayoutInflater.from(parent.context).inflate(R.layout.card_item,null,false)
        var rcv = RecyclerViewHolder(layoutView)
        return rcv

    }



    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        var card:FullInfoCard = cardsList.get(position)
        holder.tvName!!.setText(card.name)
        //holder.clCard!!.setBackgroundColor(666666)

    }

    override fun getItemCount(): Int {
        return this.cardsList.size

    }




}





