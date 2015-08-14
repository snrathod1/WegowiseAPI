package com.joulebug.wegowise.Tests

import com.google.gson.Gson
import com.joulebug.wegowise.WegoHome.CreateUtilityLogin

/**
 * Created by shraddharathod on 6/30/15.
 */
/*
{
    "username": "jane_smith",
    "password": "password123",
    "utility_company_id": 231
}
 */
object CreateUtilityLoginTest {
  def CULTest(): Unit = {

    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[CreateUtilityLogin] = gson.fromJson(json, Array[CreateUtilityLogin]().getClass)



    for (parsed <- array) {

      println("The username is " + parsed.getUsername() + ".")
      println("The password is " + parsed.getPassword() + ".")
      println("The utility company ID is " + parsed.getUtility_company_id() + ".")
    }

  }

}
