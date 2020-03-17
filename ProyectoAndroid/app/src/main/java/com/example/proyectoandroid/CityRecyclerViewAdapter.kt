package com.example.proyectoandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroid.databinding.FragmentVistaCiudadBinding
import com.example.proyectoandroid.modelos.City

class CityRecyclerViewAdapter(
    private val mProfMod: List<City>,
    private val mListener: OnListInteraction
) : RecyclerView.Adapter<CityRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityRecyclerViewAdapter.ViewHolder {
        var binder: FragmentVistaCiudadBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.fragment_vista_ciudad,
            parent,
            false
        )
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = mProfMod.size

    override fun onBindViewHolder(holder: CityRecyclerViewAdapter.ViewHolder, position: Int) {
        val item = mProfMod[position]
        holder.mView.card.setOnClickListener {
            mListener?.onListItemInteraction(item)
        }
        holder.mView.city = item
        holder.mView.executePendingBindings()
    }
    inner class ViewHolder(val mView:  FragmentVistaCiudadBinding  ) : RecyclerView.ViewHolder(mView.root) {
    }

    interface OnListInteraction {
        fun onListItemInteraction(item: City?)

    }
}