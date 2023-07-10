package com.example.listed_application

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.listed_application.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.LineChart
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)
        //bottom navigation color
        binding.bottomNavigationView.background=null
        binding.bottomNavigationView.menu.getItem(2).isEnabled=false
        // fragments
        val links_frag=links()
        val courses_frag=courses()
        val campaigns_frag=campaigns()
        val profile_frag=profile()
        setCurrentFragnment(links_frag)
        // selecting fragments
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.links -> setCurrentFragnment(links_frag)
                R.id.courses -> setCurrentFragnment(courses_frag)
                R.id.campaigns -> setCurrentFragnment(campaigns_frag)
                R.id.profile -> setCurrentFragnment(profile_frag)
            }
            true
        }
        // set the color of floating color to white
        val fab = findViewById<FloatingActionButton>(R.id.plus)
        fab.imageTintList = ColorStateList.valueOf(Color.WHITE)

    }

    private fun setCurrentFragnment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout,fragment)
            commit()
        }


}