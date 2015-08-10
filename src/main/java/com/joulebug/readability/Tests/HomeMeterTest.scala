package com.joulebug.readability.Tests

import com.google.gson.Gson
import com.joulebug.readability.WegoHome.HomeMeter

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
{
  "account_number": 'ABCD123',
  "utility_company_id": 42
  "data_type": 'electric',
  "username": 'foo',
  "password": 'bar'
}
 */
object HomeMeterTest {

  def HMTest(): Unit = {
    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[HomeMeter] = gson.fromJson(json, Array[HomeMeter]().getClass)



    for (parsed <- array) {

      println("The account number is " + parsed.getAccount_number() + ".")
      println("The utility company ID is " + parsed.getUtility_company() + ".")
      println("The data type is " + parsed.getData_type() + ".")
      println("The username is " + parsed.getUsername() + ".")
      println("The password is " + parsed.getPassword() + ".")
    }
  }
}
