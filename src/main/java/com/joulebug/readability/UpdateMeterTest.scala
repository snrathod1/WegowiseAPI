package com.joulebug.readability

import com.google.gson.Gson

/**
 * Created by shraddharathod on 6/30/15.
 */
object UpdateMeterTest {
  def UMTest(): Unit = {

    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val parsed = gson.fromJson(json, new UpdateMeter().getClass)

    println("Is there heating? " + parsed.getFor_heating())


  }

}
