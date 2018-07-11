package com.example.muhammedharis.kotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_kotlin2.*
import org.jetbrains.anko.toast

class Kotlin2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin2)
        button.setOnClickListener {
            val value = click().toString()
            toast(value)
        }
    }

    private fun click(): Int {
        return 25
    }
}
