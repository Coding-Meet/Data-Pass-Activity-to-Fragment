package com.coding.meet.datapassactivitytofragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.coding.meet.datapassactivitytofragment.bundle.BundleActivity
import com.coding.meet.datapassactivitytofragment.constructor.ConstructorActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constructorABtn = findViewById<Button>(R.id.constructorABtn)
        constructorABtn.setOnClickListener {
            startActivity(Intent(this, ConstructorActivity::class.java))
        }

        val bundleABtn = findViewById<Button>(R.id.bundleABtn)
        bundleABtn.setOnClickListener {
            startActivity(Intent(this, BundleActivity::class.java))
        }
    }
}