package com.example.proyectoandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.databinding.FragmentVistaDiaBinding

import com.example.proyectoandroid.modelos.Dias


class DiaRecyclerViewAdapter(
    private val mProfMod: List<Dias>,
    private val mListener: OnListInteraction
) : RecyclerView.Adapter<DiaRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiaRecyclerViewAdapter.ViewHolder {
        var binder: FragmentVistaDiaBinding= DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.fragment_vista_dia,
            parent,
            false
        )
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = mProfMod.size

    override fun onBindViewHolder(holder: DiaRecyclerViewAdapter.ViewHolder, position: Int) {
        val item = mProfMod[position]
        holder.mView.card3.setOnClickListener {
            mListener?.onListItemInteraction(item)
        }
        holder.mView.dia = item
        holder.mView.executePendingBindings()
    }
    inner class ViewHolder(val mView: FragmentVistaDiaBinding) : RecyclerView.ViewHolder(mView.root) {
    }

    interface OnListInteraction {
        fun onListItemInteraction(item: Dias?)

    }
}