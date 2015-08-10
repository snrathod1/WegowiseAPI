package com.joulebug.readability.Tests

import com.google.gson.Gson
import com.joulebug.readability.WegoHome.HomeMeterList

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
{
    "id": 1,
    "buildings_count": 1,
    "coverage": 'all',
    "data_type": 'Gas',
    "for_heating": false,
    "notes": 'Some notes',
    "scope": 'HomeMeter',
    "utility_company": {
      "id": 23,
      "name": "Con Edison"
    }
  },
 */
object HomeMeterListTest {
  def HMLTest(): Unit = {
    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[HomeMeterList] = gson.fromJson(json, Array[HomeMeterList]().getClass)



    for (parsed <- array) {

      println("The ID is " + parsed.getId() + ".")
      println("The number of buildings is " + parsed.getBuildings_count() + ".")
      println("The coverage is " + parsed.getCoverage() + ".")
      println("The data type is " + parsed.getData_type() + ".")
      println("Is it for heating " + parsed.getFor_heating() + ".")
      println("Notes: " + parsed.getNotes() + ".")
      println("The scope is " + parsed.getScope() + ".")
      println("The Utility Company ID is " + parsed.getUtility_company().getId() + ".")
      println("The Utility Company name is " + parsed.getUtility_company().getName() + ".")
    }
  }

}
