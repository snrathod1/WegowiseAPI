package com.joulebug.readability
import com.google.gson.Gson
import scala.io.Source
/**
 * Created by shraddharathod on 6/30/15.
 */
/*
{
    "id": 23,
    "data_type": "Gas",
    "name": "Con Edison",
    "short_name": "ConEd",
    "state_code": "PA"
  }
 */
object UtilityCompanyTest {
  def UCTest(): Unit = {
    println("Please enter the data file:")
    val name = Console.readLine
    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString

    val array: Array[UtilityCompany] = gson.fromJson(json, Array[UtilityCompany]().getClass)



    for (parsed <- array) {
      println("The ID is " + parsed.getId() + ".")
      println("The data type is " + parsed.getData_type() + ".")
      println("The name of the utility company is " + parsed.getShort_name() + ".")
      println("The state abbreviation is " + parsed.getState_code + ".")

    }
  }


  //object - single thing
  //UtilityCompanyTest.UCTest()

  //class - object 'factory'
  //new UtilityCompany().method()
}




