package com.coding.meet.datapassactivitytofragment.constructor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.coding.meet.datapassactivitytofragment.R

class DataClassFragment(private val user: User) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data_class, container, false)

        val rollNoTxt = view.findViewById<TextView>(R.id.rollNoTxt)
        val nameTxt = view.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = view.findViewById<TextView>(R.id.ageTxt)
        val salaryTxt = view.findViewById<TextView>(R.id.salaryTxt)
        val genderTxt = view.findViewById<TextView>(R.id.genderTxt)

        rollNoTxt.text = user.id.toString()
        nameTxt.text = user.name
        ageTxt.text = user.age.toString()
        salaryTxt.text = user.salary.toString()
        genderTxt.text = if (user.gender) "Male" else "Female"

        return view
    }
}