package com.joulebug.wegowise.Tests

import com.google.gson.Gson
import com.joulebug.wegowise.WegoHome.CreateAMeter

/**
 * Created by shraddharathod on 6/30/15.
 */
/**
 * {
        "account_number": "123456789",
        "utility_company_id": 231,
        "username": "jane_smith",
        "password": "pasword123",
        "data_type": "Gas"
        }
 */
object CreateAMeterTest {
  def CAMTest(): Unit = {
    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[CreateAMeter] = gson.fromJson(json, Array[CreateAMeter]().getClass)



    for (parsed <- array) {

      println("The account number is " + parsed.getAccount_number() + ".")
      println("The utility company ID is " + parsed.getUtility_company() + ".")
      println("The username is " + parsed.getUsername() + ".")
      println("The password is " + parsed.getPassword() + ".")
      println("The data type is " + parsed.getData_type() + ".")
    }
  }
}
