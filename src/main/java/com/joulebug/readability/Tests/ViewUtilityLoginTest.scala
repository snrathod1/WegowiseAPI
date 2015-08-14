package com.joulebug.readability.Tests

import com.google.gson.Gson
import com.joulebug.readability.WegoData.ViewUtilityLogin

/**
 * Created by shraddharathod on 6/30/15.
 */
/*
{
    "id": 1,
    "status": "success",
    "username": "abcproperties",
    "utility_company": {
        "name": "NSTAR"
    },
    "account_numbers": [
        "abc123",
        "xyz987"
    ]
}
 */
object ViewUtilityLoginTest {

  def VULTest(): Unit = {
    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString

    val array: Array[ViewUtilityLogin] = gson.fromJson(json, Array[ViewUtilityLogin]().getClass)



    for (parsed <- array) {

      println("The ID is " + parsed.getId() + ".")
      println("The status is " + parsed.getStatus() + ".")
      println("The username is " + parsed.getUsername() + ".")
      println("The name of the utility company is " + parsed.getUtility_company().getName + ".")
      println("The account number(s) is(are) " + parsed.getAccount_numbers().mkString(" , ") + " .")
    }
  }


}
