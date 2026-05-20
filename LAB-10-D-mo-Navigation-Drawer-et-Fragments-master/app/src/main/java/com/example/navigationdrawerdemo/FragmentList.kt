package com.example.navigationdrawerdemo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.ListFragment

class FragmentList : ListFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = Array(20) { "Item ${it + 1}" }

        val adapter = object : ArrayAdapter<String>(
            requireActivity(),
            R.layout.item_list_row,
            R.id.tv_name,
            items
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val tvNumber = view.findViewById<TextView>(R.id.tv_number)
                val tvName = view.findViewById<TextView>(R.id.tv_name)
                
                tvNumber.text = (position + 1).toString()
                tvName.text = getItem(position)
                
                return view
            }
        }
        listAdapter = adapter
    }
}
