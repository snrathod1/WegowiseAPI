package com.joulebug.readability

import com.google.gson.Gson

/**
 * Created by shraddharathod on 6/30/15.
 */
/*
 {
    "delivery_charge": null,
    "end_date": "2014-01-31",
    "fuel_charge": null,
    "total_charge": "10.0",
    "start_date": "2014-01-01",
    "gallons": null,
    "kwh": "0.292997363023733",
    "btu": 1000,
    "demand_charge": null,
    "demand_kw": null,
    "fixed_charge": null,
    "off_peak_charge": null,
    "off_peak_kwh": null,
    "peak_charge": null,
    "peak_kwh": null,
  }
 */
object MeterRawDataTest {
  def MRDTest (): Unit = {

    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString

    val parsed = gson.fromJson(json, new MeterRawData().getClass)

    println("The delivery charge is " + parsed.getDelivery_charge() + ".")
    println("The end date is " + parsed.getEnd_date() + ".")
    println("The fuel charge is " + parsed.getFuel_charge() + ".")
    println("The total charge is " + parsed.getTotal_charge() + ".")
    println("The start date is " + parsed.getStart_date() + ".")
    println("The number of gallons is " + parsed.getGallons() + ".")
    println("The kwh is " + parsed.getKwh()+ ".")
    println("The btu is " + parsed.getBtu() + ".")
    println("The demand charge is " + parsed.getDemand_charge() + ".")
    println("The kw demand is " + parsed.getDemand_kw() + ".")
    println("The fixed charge is " + parsed.getFixed_charge()+ ".")
    println("The off-peak charge is " + parsed.getOff_peak_charge() + ".")
    println("The off-peak kwh is " + parsed.getOff_peak_kwh() + ".")
    println("The peak charge is " + parsed.getPeak_charge() + ".")
    println("The peak kwh is " + parsed.getPeak_kwh()+ ".")

  }

}
