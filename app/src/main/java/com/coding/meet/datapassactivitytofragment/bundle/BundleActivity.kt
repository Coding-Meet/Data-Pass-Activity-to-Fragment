package com.coding.meet.datapassactivitytofragment.bundle

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.coding.meet.datapassactivitytofragment.constructor.IndividualBundleFragment
import com.coding.meet.datapassactivitytofragment.R
import com.coding.meet.datapassactivitytofragment.bundle.parcelable.ParcelableFragment
import com.coding.meet.datapassactivitytofragment.bundle.parcelable.UserParcelable
import com.coding.meet.datapassactivitytofragment.bundle.serializable.SerializableBundleFragment
import com.coding.meet.datapassactivitytofragment.bundle.serializable.UserSerializable

class BundleActivity : AppCompatActivity() {
    private var genderState = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle)

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

        // Individual
        val individualFBundleBtn = findViewById<Button>(R.id.individualFBundleBtn)
        individualFBundleBtn.setOnClickListener {
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


                val bundle = Bundle().apply {
                    putLong("id",id)
                    putString("name",name)
                    putInt("age",age)
                    putDouble("salary",salary)
                    putBoolean("gender",genderState)
                }

                val individualBundleFragment = IndividualBundleFragment().apply {
                    arguments = bundle
                }
                replaceFragment(individualBundleFragment)

            }
        }


        // Serializable
        val serializableBundleBtn = findViewById<Button>(R.id.serializableBundleBtn)
        serializableBundleBtn.setOnClickListener {
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

                val userSerializable = UserSerializable(
                    id, name, age, salary,genderState)

                val bundle = Bundle().apply {
                    putSerializable("userSerializable",userSerializable)
                }

                val serializableBundleFragment = SerializableBundleFragment().apply {
                    arguments = bundle
                }
                replaceFragment(serializableBundleFragment)
            }
        }

        val parcelableBundleBtn = findViewById<Button>(R.id.parcelableBundleBtn)
        parcelableBundleBtn.setOnClickListener {
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

                val userParcelable = UserParcelable(
                    id, name, age, salary,genderState)

                val bundle = Bundle().apply {
                    putParcelable("userParcelable",userParcelable)
                }

                val parcelableFragment = ParcelableFragment().apply {
                    arguments = bundle
                }
                replaceFragment(parcelableFragment)
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