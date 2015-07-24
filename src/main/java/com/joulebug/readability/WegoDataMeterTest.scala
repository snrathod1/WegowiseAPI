package com.joulebug.readability
import com.google.gson.Gson
/*
{
    "coverage": "none",
    "data_type": "Gas",
    "for_heating": false,
    "id": 1,
    "notes": "Some notes",
    "utility_company":
      {
        "id": 1,
        "name": "UtilityCo1"
      }
  }
 */
/**
 * Created by shraddharathod on 6/30/15.
 */
object WegoDataMeterTest {
  def DOMTest (): Unit = {

    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[WegoDataMeter] = gson.fromJson(json, Array[WegoDataMeter]().getClass)

    for (parsed <- array) {
      println("The coverage is " + parsed.getCoverage() + ".")
      println("The data type is " + parsed.getData_type() + ".")
      println("Is it for heating? " + parsed.getFor_heating())
      println("The ID is " + parsed.getId() + ".")
      println("Notes: " + parsed.getNotes() + ".")
      println("The utility company ID is " + parsed.getUtility_company().getId() + ".")
      println("The name of the utility company is " + parsed.getUtility_company().getName() + ".")
    }
  }

}
