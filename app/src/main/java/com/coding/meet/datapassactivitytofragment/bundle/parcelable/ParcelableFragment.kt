package com.coding.meet.datapassactivitytofragment.bundle.parcelable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.coding.meet.datapassactivitytofragment.R
import com.coding.meet.datapassactivitytofragment.bundle.getParcelableCompat

class ParcelableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_parcelable, container, false)
        val bundle = arguments

        val rollNoTxt = view.findViewById<TextView>(R.id.rollNoTxt)
        val nameTxt = view.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = view.findViewById<TextView>(R.id.ageTxt)
        val salaryTxt = view.findViewById<TextView>(R.id.salaryTxt)
        val genderTxt = view.findViewById<TextView>(R.id.genderTxt)

        if (bundle != null) {

            val userParcelable =
                bundle.getParcelableCompat("userParcelable", UserParcelable::class.java)
            rollNoTxt.text = userParcelable.id.toString()
            nameTxt.text = userParcelable.name
            ageTxt.text = userParcelable.age.toString()
            salaryTxt.text = userParcelable.salary.toString()
            genderTxt.text = if (userParcelable.gender) "Male" else "Female"
        }

        return view


    }

}