package com.sahraer.instagramclon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.sahraer.instagramclon.databinding.LoginTabFragmentBinding

class LoginTabFragment : Fragment() {
    private var _binding: LoginTabFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var auth : FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = LoginTabFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        auth = FirebaseAuth.getInstance()


        return view
    }



}