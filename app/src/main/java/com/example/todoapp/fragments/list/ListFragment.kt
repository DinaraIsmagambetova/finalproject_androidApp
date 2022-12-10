package com.example.todoapp.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val button = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        val list = view.findViewById<ConstraintLayout>(R.id.listLayout)
        list.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_updateFragment)
        }
        //set menu
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.list_fragment_menu,menu)
    }
}