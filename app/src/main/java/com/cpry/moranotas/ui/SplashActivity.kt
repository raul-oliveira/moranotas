package com.cpry.moranotas.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.cpry.moranotas.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        configure()
    }

    private fun configure() {
        imageView.setOnClickListener {
            goHome()
        }
    }

    fun goHome() {
        val i = Intent(this, NotesActivity::class.java)
        startActivity(i)
    }
}
