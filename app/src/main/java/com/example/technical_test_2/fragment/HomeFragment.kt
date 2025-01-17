package com.example.technical_test_2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.technical_test_2.R
import androidx.navigation.fragment.findNavController



class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val studentListButton = view.findViewById<LinearLayout>(R.id.studentlist_button)
        val logoutButton = view.findViewById<LinearLayout>(R.id.logout_button)

        studentListButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_studentListFragment)
        }

        logoutButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }
}