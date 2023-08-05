package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var weight = 0
    var age = 0
    var typeofuser = "0"
    var weight2: String? = null
    var age2: String? = null
    var seekbarprogress = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        val btn = findViewById<Button>(R.id.calculatebmi)
        val Male = findViewById<CardView>(R.id.male)
        val Female = findViewById<CardView>(R.id.female)
        val incAge = findViewById<ImageView>(R.id.incrementAge)
        val decAge = findViewById<ImageView>(R.id.decrementAge)
        val currentAge = findViewById<TextView>(R.id.currentAge)
        val incWeight = findViewById<ImageView>(R.id.incrementWeight)
        val decWeight = findViewById<ImageView>(R.id.decrementWeight)
        val currentWeight = findViewById<TextView>(R.id.currentWeight)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val currentHeight = findViewById<TextView>(R.id.currentHeight)
        Male.setOnClickListener {
            Male.background =
                ContextCompat.getDrawable(applicationContext, R.drawable.malefemale_focusbackground)
            Female.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.malefemale_notfocusbackground
            )
            typeofuser = "Male"
        }
        Female.setOnClickListener {
            Female.background =
                ContextCompat.getDrawable(applicationContext, R.drawable.malefemale_focusbackground)
            Male.background = ContextCompat.getDrawable(
                applicationContext,
                R.drawable.malefemale_notfocusbackground
            )
            typeofuser = "Female"
        }
        age = 17
        incAge.setOnClickListener {
            age++
            age2 = age.toString()
            currentAge.text = "" + age2
        }
        decAge.setOnClickListener {
            if (age <= 1) {
                Toast.makeText(applicationContext, "Invalid Age", Toast.LENGTH_LONG).show()
            } else age--
            age2 = age.toString()
            currentAge.text = "" + age2
        }
        weight = 51
        incWeight.setOnClickListener {
            weight++
            weight2 = weight.toString()
            currentWeight.text = "" + weight2
        }
        decWeight.setOnClickListener {
            if (weight <= 2) {
                Toast.makeText(applicationContext, "Invalid Weight", Toast.LENGTH_LONG).show()
            } else weight--
            weight2 = weight.toString()
            currentWeight.text = "" + weight2
        }
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekbarprogress = progress.toString()
                currentHeight.text = "" + seekbarprogress
                seekBar.max = 350
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        btn.setOnClickListener {
            if (typeofuser == "0") {
                Toast.makeText(applicationContext, "Select Your Gender First", Toast.LENGTH_SHORT)
                    .show()
            } else if (seekbarprogress == "0") {
                Toast.makeText(applicationContext, "Select Your Height First", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this@MainActivity, BmiActivity::class.java)
                intent.putExtra("Gender", typeofuser)
                intent.putExtra("Height", seekbarprogress)
                intent.putExtra("Age", age2)
                intent.putExtra("Weight", weight2)
                startActivity(intent)
            }
        }
    }
}