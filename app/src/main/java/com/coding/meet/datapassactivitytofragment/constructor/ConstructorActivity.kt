package com.coding.meet.datapassactivitytofragment.constructor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.coding.meet.datapassactivitytofragment.R

class ConstructorActivity : AppCompatActivity() {
    private var genderState = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constructor)

        val edRollNo = findViewById<EditText>(R.id.edRollNo)
        val edName = findViewById<EditText>(R.id.edName)
        val edAge = findViewById<EditText>(R.id.edAge)
        val edSalary = findViewById<EditText>(R.id.edSalary)

        val genderRG = findViewById<RadioGroup>(R.id.genderRG)
        genderRG.setOnCheckedChangeListener { radioGroup, id ->
            if (id == R.id.radioMale){
                genderState = true
            }else if (id == R.id.radioFemale){
                genderState = false
            }
        }

        /// First Way
        val individualFConBtn = findViewById<Button>(R.id.individualFConBtn)
        individualFConBtn.setOnClickListener {
            if (edRollNo.text.toString().isEmpty()){
                edRollNo.error = "Required"
            } else if (edName.text.toString().isEmpty()){
                edName.error = "Required"
            } else if (edAge.text.toString().isEmpty()){
                edAge.error = "Required"
            } else if (edSalary.text.toString().isEmpty()){
                edSalary.error = "Required"
            } else {
                // Long
                val id = edRollNo.text.toString().trim().toLong()

                // String
                val name = edName.text.toString().trim()

                // Int
                val age = edAge.text.toString().trim().toInt()


                // Double
                val salary = edSalary.text.toString().trim().toDouble()


                replaceFragment(IndividualFragment(id, name, age, salary, genderState))
            }
        }

        // Second Way
        val dataClassConBtn = findViewById<Button>(R.id.dataClassConBtn)
        dataClassConBtn.setOnClickListener {
            if (edRollNo.text.toString().isEmpty()){
                edRollNo.error = "Required"
            } else if (edName.text.toString().isEmpty()){
                edName.error = "Required"
            } else if (edAge.text.toString().isEmpty()){
                edAge.error = "Required"
            } else if (edSalary.text.toString().isEmpty()){
                edSalary.error = "Required"
            } else {
                // Long
                val id = edRollNo.text.toString().trim().toLong()

                // String
                val name = edName.text.toString().trim()

                // Int
                val age = edAge.text.toString().trim().toInt()


                // Double
                val salary = edSalary.text.toString().trim().toDouble()

                val user = User(
                    id, name, age, salary,genderState
                )

                replaceFragment(DataClassFragment(user))
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,fragment)
            .commit()
    }
}