package com.example.technical_test_2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.technical_test_2.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val usernameInput = view.findViewById<EditText>(R.id.UsernameInput)
        val passwordInput = view.findViewById<EditText>(R.id.PasswordInput)
        val btnLogin = view.findViewById<View>(R.id.LoginButton)
        btnLogin.setOnClickListener{
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
                Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (username == "alfagift-admin" && password == "asdf") {
                findNavController().navigate(R.id.action_loginFragment_to_studentListFragment)
            } else {
                Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}