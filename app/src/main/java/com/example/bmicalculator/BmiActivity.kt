package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BmiActivity : AppCompatActivity() {
    var height: String? = null
    var weight: String? = null
    var bmi: String? = null
    var intbmi = 0
    var Floatheight = 0f
    var Floatweight = 0f
    var Floatbmi = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        supportActionBar!!.hide()
        val btn1 = findViewById<Button>(R.id.recalculatebmi)
        val resultDisplay = findViewById<TextView>(R.id.resultdisplay)
        val genderTitle = findViewById<TextView>(R.id.gendertitle)
        val bmiCategory = findViewById<TextView>(R.id.bmicategory)
        val resultSign = findViewById<ImageView>(R.id.resultsign)
        val intent = intent
        height = intent.getStringExtra("Height")
        weight = intent.getStringExtra("Weight")
        Floatheight = height!!.toFloat()
        Floatweight = weight!!.toFloat()
        Floatheight = Floatheight / 100
        Floatbmi = Floatweight / (Floatheight * Floatheight)
        bmi = java.lang.Float.toString(Floatbmi)
        if (Floatbmi < 16) {
            bmiCategory.text = "Severe Thinness"
            resultSign.setImageResource(R.drawable.cross)
        } else if (Floatbmi < 16.9 && Floatbmi > 16) {
            bmiCategory.text = "Moderate Thinness"
            resultSign.setImageResource(R.drawable.warning)
        } else if (Floatbmi < 18.4 && Floatbmi > 17) {
            bmiCategory.text = "Mild Thinness"
            resultSign.setImageResource(R.drawable.warning)
        } else if (Floatbmi < 25 && Floatbmi > 18.4) {
            bmiCategory.text = "Normal"
            resultSign.setImageResource(R.drawable.ok)
        } else if (Floatbmi < 29.4 && Floatbmi > 25) {
            bmiCategory.text = "OverWeight"
            resultSign.setImageResource(R.drawable.warning)
        } else {
            bmiCategory.text = "Obese Class I"
            resultSign.setImageResource(R.drawable.warning)
        }
        genderTitle.text = intent.getStringExtra("Gender")
        resultDisplay.text = bmi
        btn1.setOnClickListener {
            val ca = Intent(this@BmiActivity, MainActivity::class.java)
            startActivity(ca)
            finish()
        }
    }
}