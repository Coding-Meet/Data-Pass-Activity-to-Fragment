package com.coding.meet.datapassactivitytofragment.bundle.serializable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.coding.meet.datapassactivitytofragment.R
import com.coding.meet.datapassactivitytofragment.bundle.getSerializableCompat


class SerializableBundleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_serializable_bundle, container, false)

        val bundle = arguments

        val rollNoTxt = view.findViewById<TextView>(R.id.rollNoTxt)
        val nameTxt = view.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = view.findViewById<TextView>(R.id.ageTxt)
        val salaryTxt = view.findViewById<TextView>(R.id.salaryTxt)
        val genderTxt = view.findViewById<TextView>(R.id.genderTxt)

        if (bundle != null) {

            val userSerializable =
                bundle.getSerializableCompat("userSerializable", UserSerializable::class.java)
            rollNoTxt.text = userSerializable.id.toString()
            nameTxt.text = userSerializable.name
            ageTxt.text = userSerializable.age.toString()
            salaryTxt.text = userSerializable.salary.toString()
            genderTxt.text = if (userSerializable.gender) "Male" else "Female"
        }

        return view
    }
}