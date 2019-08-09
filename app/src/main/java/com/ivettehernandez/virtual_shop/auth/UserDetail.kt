package com.ivettehernandez.virtual_shop.auth

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ivettehernandez.virtual_shop.R
import com.google.android.gms.plus.PlusOneButton

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * [UserDetail.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [UserDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserDetail : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_detail, container, false)


        return view
    }

    override fun onResume() {
        super.onResume()

    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
         //   throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }


}
