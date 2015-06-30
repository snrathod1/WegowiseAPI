package com.joulebug.readability

import com.google.gson.Gson

/**
 * Created by shraddharathod on 6/30/15.
 */
object MeterRawDatapointTest {
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
  def MRDPTest(): Unit = {
    val gson = new Gson()
    val json = "{\n  \"start_date\": \"2012-02-01\",\n  \"end_date\": \"2012-03-04\",\n  \"btu\": \"100000\",\n  \"total_charge\": \"300.0\",\n  \"delivery_charge\": \"100.0\",\n  \"fixed_charge\": \"80.0\"\n}"
    val parsed = gson.fromJson(json, new MeterRawDatapoint().getClass)

    println("The start date is " + parsed.getStart_date() + ".")
    println("The end date is " + parsed.getEnd_date() + ".")
    println("The btu is " + parsed.getBtu() + ".")
    println("The total charge is " + parsed.getTotal_charge() + ".")
    println("The delivery charge is " + parsed.getDelivery_charge() + ".")
    println("The fixed charge is " + parsed.getFixed_charge() + ".")


  }
}
