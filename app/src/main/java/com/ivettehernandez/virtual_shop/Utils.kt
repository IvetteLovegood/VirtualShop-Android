package com.ivettehernandez.virtual_shop


/**
 * Created by Ivette Hernández on 2019-08-08.
 */

object Utils {

    private const val url = "https://api-rest-virtualshop.herokuapp.com/"

    const val login = "${url}api/signin"
    const val register = "${url}api/signup"

    var token = ""

}