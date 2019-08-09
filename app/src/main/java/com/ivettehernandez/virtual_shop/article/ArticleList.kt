package com.ivettehernandez.virtual_shop.article

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.ivettehernandez.virtual_shop.R
import com.ivettehernandez.virtual_shop.utils.Utils
import org.json.JSONObject
import java.util.HashMap


class ArticleList : Fragment() {

    private var listener: OnFragmentInteractionListener? = null


    fun onCreate(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        val view= inflater.inflate(R.layout.list_infinity,container,false)
        val recyclerContext = view.findViewById(R.id.recyclerView) as RecyclerView
        val dataList = mutableListOf<Article>()
        val layoutManager = LinearLayoutManager(this.requireContext())

        val queue = Volley.newRequestQueue(this.requireContext())
        val urlArticle = Utils.article

        val preferences = PreferenceManager.getDefaultSharedPreferences(this.requireContext())
        val tokenUser = preferences.getString("token", "")

        Log.e("tokenUser", tokenUser)

        val getRequest = @SuppressLint("CommitPrefEdits")
        object : StringRequest(
            Method.GET, urlArticle,
            Response.Listener { response ->
                Log.d("Response", response)

                if (!response.isEmpty()) {

                    val jsonObject = JSONObject(response)

                    val articleObject = jsonObject.getJSONObject("products")

                    var x = 0
                    while (x < articleObject.length()) {
                        val articleObjects = articleObject.getJSONObject(x.toString())
                        dataList.add(
                            Article(
                            articleObject.getString("_id"),
                            articleObject.getString("nombre"),
                            articleObject.getString("imagen"),
                            articleObject.getString("descripcion"),
                                articleObject.getInt("precio")
                        )
                        )
                        x++
                    }


                    val adapter = ArticleAdapter(recyclerList = dataList)
                    recyclerContext.layoutManager = layoutManager
                    recyclerContext.adapter = adapter

                }

            },
            Response.ErrorListener { response ->
                Log.d("Error.Response", response.toString())
            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val params = HashMap<String, String>()
                params["Authorization"] = "Bearer $tokenUser"

                return params
            }
        }
        queue.add(getRequest)

        return  view
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
          //  throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }


}
