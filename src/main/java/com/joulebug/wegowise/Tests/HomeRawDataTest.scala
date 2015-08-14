package com.joulebug.wegowise.Tests

import com.google.gson.Gson
import com.joulebug.wegowise.WegoHome.HomeRawData

/**
 * Created by shraddharathod on 7/9/15.
 */

/*
{
  "start_date": "2012-02-01",
  "end_date": "2012-03-04",
  "btu": "100000",
  "total_charge": "300.0",
  "delivery_charge": "100.0",
  "fixed_charge": "80.0"
}
 */
object HomeRawDataTest {
  def HRDTest(): Unit = {

    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[HomeRawData] = gson.fromJson(json, Array[HomeRawData]().getClass)



    for (parsed <- array) {
      println("The start date is " + parsed.getStart_date() + ".")
      println("The end date is " + parsed.getEnd_date() + ".")
      println("The btu is " + parsed.getBtu() + ".")
      println("The total charge is " + parsed.getTotal_charge() + ".")
      println("The delivery charge is " + parsed.getDelivery_charge() + ".")
      println("The fixed charge is " + parsed.getFixed_charge() + ".")
    }

  }

}
