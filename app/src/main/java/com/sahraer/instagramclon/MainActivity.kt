package com.sahraer.instagramclon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.sahraer.instagramclon.databinding.ActivityFeedBinding
import com.sahraer.instagramclon.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //ViewPager için adapter nesnesi oluşturuyoruz ve kullanacağımız fragment, title'ları ekliyoruz.
        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(LoginTabFragment(), "Login")
        adapter.addFragment(SignUpFragment(), "SignUp")

        //Adapter'ımızdaki verileri viewPager adapter'a veriyoruz
        viewPager.adapter = adapter
        //Tablar arasında yani viewPager'lar arasında geçisi sağlıyoruz
        tab_layout.setupWithViewPager(viewPager)

    }



    fun signInClick(view: View){

    }


}