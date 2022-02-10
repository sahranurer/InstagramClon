package com.sahraer.instagramclon.view

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

        //güncel kullanıcı
        val currentUser = auth.currentUser
        if(currentUser!=null){
            val intent = Intent(this.context, FeedActivity::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener {
            val email = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()

            if(email.equals("") && password.equals("")){
                Toast.makeText(this.context,"Enter email and password !",Toast.LENGTH_LONG).show()

            }else{
                auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                    val intent = Intent(this.context, FeedActivity::class.java)
                    startActivity(intent)
                }.addOnFailureListener {
                    Toast.makeText(this.context,it.localizedMessage,Toast.LENGTH_LONG).show()
                }
            }


        }



        return view
    }



}