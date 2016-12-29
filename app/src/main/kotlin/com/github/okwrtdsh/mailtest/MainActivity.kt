package com.github.okwrtdsh.mailtest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import butterknife.bindView

class MainActivity : AppCompatActivity() {
    val button1: Button by bindView(R.id.button1)
    val button2: Button by bindView(R.id.button2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            Intent(applicationContext, Test1Activity::class.java).let { startActivity(it) }
        }
        button2.setOnClickListener {
            Intent(applicationContext, Test2Activity::class.java).let { startActivity(it) }
        }
    }
}
