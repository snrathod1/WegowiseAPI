package com.joulebug.readability

import com.google.gson.Gson
import com.joulebug.readability.{WegoDataClient}

/**
 * Created by shraddharathod on 8/7/15.
 */

object WegoDataClientTest {
  private var id = 0;

  def WDCTest() {
    println("Please enter in your Key:")
    val key = Console.readLine().mkString

    println("Please enter in your Secret:")
    val secret = Console.readLine().mkString

    val WDC = new WegoDataClient(key, secret)

    WDC.run()

    val arrayOne: Array[WegoDataMeter] = WDC.getDataOnlyMeter()

    for (parsed <- arrayOne) {
      println("Coverage: " + parsed.getCoverage())
      println("Data-Type: " + parsed.getData_type())
      println("For heating? " + parsed.getFor_heating())
      WegoDataClientTest.id = parsed.getId()
      println(id)
      println("Notes: " + parsed.getNotes())
      println("Utility Company ID: " + parsed.getUtility_company.getId())
      println("Utility Company Name: " + parsed.getUtility_company.getName())
    }
    val arrayTwo: Array[WegoDataMeter] = WDC.getWegoDataMeterWithID(id)

    for (parsed <- arrayTwo) {
      println("Coverage: " + parsed.getCoverage())
      println("Data-Type: " + parsed.getData_type())
      println("For heating? " + parsed.getFor_heating())
      println("ID: " + parsed.getId())
      println("Notes: " + parsed.getNotes())
      println("Utility Company ID: " + parsed.getUtility_company.getId())
      println("Utility Company Name: " + parsed.getUtility_company.getName())
    }

    val arrayThree: Array[ViewUtilityLogin] = WDC.getViewLogin(id)

    for (parsed <- arrayThree) {
      println("ID: " + parsed.getId())
      println("Status: " + parsed.getStatus())
      println("Username: " + parsed.getUsername())
      println("Utility Company Name: " + parsed.getUtility_company().getName())
      println("Account Numbers: " + parsed.getAccount_numbers())
    }
    val arrayFour: Array[WegoDataRawData] = WDC.getMeterRawData(id)
    for (parsed <- arrayFour) {

      println("Delivery Charge: " + parsed.getDelivery_charge())
      println("End date: " + parsed.getEnd_date())
      println("Fuel Charge: " + parsed.getFuel_charge())
      println("Total Charge: " + parsed.getTotal_charge())
      println("Start Date: " + parsed.getStart_date())
      println("Gallons: " + parsed.getGallons())
      println("Kwh: " + parsed.getKwh())
      println("Btu: " + parsed.getBtu())
      println("Demand Charge: " + parsed.getDemand_charge())
      println("Demand kw: " + parsed.getDemand_kw())
      println("Fixed Charge: " + parsed.getFixed_charge())
      println("Off Peak Charge: " + parsed.getOff_peak_charge())
      println("Off Peak kwh: " + parsed.getOff_peak_kwh())
      println("Peak Charge: " + parsed.getPeak_charge())
      println("Peak kwh: " + parsed.getPeak_kwh())
    }

    val arrayFive: Array[WegoDataRawData] = WDC.getMeterRawDataPoint(id)
    for (parsed <- arrayFive) {
      println("Delivery Charge: " + parsed.getDelivery_charge())
      println("End date: " + parsed.getEnd_date())
      println("Fuel Charge: " + parsed.getFuel_charge())
      println("Total Charge: " + parsed.getTotal_charge())
      println("Start Date: " + parsed.getStart_date())
      println("Gallons: " + parsed.getGallons())
      println("Kwh: " + parsed.getKwh())
    }



    val arraySix: Array[WegoDataRawData] = WDC.getMeterRawDatum(id)
    for (parsed <- arraySix) {

      println("Delivery Charge: " + parsed.getDelivery_charge())
      println("End date: " + parsed.getEnd_date())
      println("Fuel Charge: " + parsed.getFuel_charge())
      println("Total Charge: " + parsed.getTotal_charge())
      println("Start Date: " + parsed.getStart_date())
      println("Gallons: " + parsed.getGallons())
      println("Kwh: " + parsed.getKwh())
      println("Btu: " + parsed.getBtu())
      println("Demand Charge: " + parsed.getDemand_charge())
      println("Demand kw: " + parsed.getDemand_kw())
      println("Fixed Charge: " + parsed.getFixed_charge())
      println("Off Peak Charge: " + parsed.getOff_peak_charge())
      println("Off Peak kwh: " + parsed.getOff_peak_kwh())
      println("Peak Charge: " + parsed.getPeak_charge())
      println("Peak kwh: " + parsed.getPeak_kwh())
    }

  }
}


