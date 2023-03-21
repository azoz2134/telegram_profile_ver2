package com.example.telegram_profile_ver2

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.telegram_profile_ver2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val files = Files()
    private val links = Links()
    private val media = Media()
    private lateinit var binder: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        replaceFragment(media)
        binder.navBar.setOnItemReselectedListener {
            when(it.itemId){
                R.id.nav_Media -> replaceFragment(media)
                R.id.nav_Files -> replaceFragment(files)
                R.id.nav_Link -> replaceFragment(links)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }

}