package com.coding.meet.datapassactivitytofragment.constructor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.coding.meet.datapassactivitytofragment.R

class IndividualBundleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_individual_bundle, container, false)

        val bundle = arguments

        val rollNoTxt = view.findViewById<TextView>(R.id.rollNoTxt)
        val nameTxt = view.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = view.findViewById<TextView>(R.id.ageTxt)
        val salaryTxt = view.findViewById<TextView>(R.id.salaryTxt)
        val genderTxt = view.findViewById<TextView>(R.id.genderTxt)

        if (bundle != null) {
            rollNoTxt.text = bundle.getLong("id", 0).toString()
            nameTxt.text = bundle.getString("name", "")
            ageTxt.text = bundle.getInt("age", 0).toString()
            salaryTxt.text = bundle.getDouble("salary", 0.0).toString()
            genderTxt.text = if (bundle.getBoolean("gender", true)) "Male" else "Female"
        }

        return view
    }

}