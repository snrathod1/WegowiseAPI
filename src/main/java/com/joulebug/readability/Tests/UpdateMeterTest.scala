package com.joulebug.readability.Tests

import com.google.gson.Gson
import com.joulebug.readability.UpdateMeter

/**
 * Created by shraddharathod on 6/30/15.
 */
object UpdateMeterTest {
  def UMTest(): Unit = {

    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[UpdateMeter] = gson.fromJson(json, Array[UpdateMeter]().getClass)



    for (parsed <- array) {
      println("Is there heating? " + parsed.getFor_heating())
    }

  }

}
