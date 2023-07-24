package com.coding.meet.datapassactivitytofragment.constructor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.coding.meet.datapassactivitytofragment.R


class IndividualFragment(
    private val rollNo: Long,
    private val name: String,
    private val age: Int,
    private val salary: Double,
    private val genderState: Boolean,
) :
    Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_individual, container, false)

        val rollNoTxt = view.findViewById<TextView>(R.id.rollNoTxt)
        val nameTxt = view.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = view.findViewById<TextView>(R.id.ageTxt)
        val salaryTxt = view.findViewById<TextView>(R.id.salaryTxt)
        val genderTxt = view.findViewById<TextView>(R.id.genderTxt)

        rollNoTxt.text = rollNo.toString()
        nameTxt.text = name
        ageTxt.text = age.toString()
        salaryTxt.text = salary.toString()
        genderTxt.text = if (genderState) "Male" else "Female"

        return view
    }
}