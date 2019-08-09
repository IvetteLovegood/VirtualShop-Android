package com.ivettehernandez.virtual_shop.utils


/**
 * Created by Ivette Hernández on 2019-08-08.
 */

object Utils {

    private const val url = "https://api-rest-virtualshop.herokuapp.com/"

    const val login = "${url}api/signin"
    const val register = "${url}api/signup"
    const val user = "${url}api/user/"

    var token: String? = null
    var _id: String? = "5d4c58087c3f1100045df6d6"

}