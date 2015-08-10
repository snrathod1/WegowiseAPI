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
      println(parsed.getId())
      println(parsed.getStatus())
      println(parsed.getUsername())
      println(parsed.getUtility_company().getName())
      println(parsed.getAccount_numbers())
    }
    val arrayFour: Array[WegoDataRawData] = WDC.getMeterRawData(id)
      for(parsed <- arrayFour) {

        println(parsed.getDelivery_charge())
        println(parsed.getEnd_date())
        println(parsed.getFuel_charge())
        println(parsed.getTotal_charge())
        println(parsed.getStart_date())
        println(parsed.getGallons())
        println(parsed.getKwh())
        println(parsed.getBtu())
        println(parsed.getDemand_charge())
        println(parsed.getDemand_kw())
        println(parsed.getFixed_charge())
        println(parsed.getOff_peak_charge())
        println(parsed.getOff_peak_kwh())
        println(parsed.getPeak_charge())
        println(parsed.getPeak_kwh())
    }

    val arrayFive: Array[WegoDataRawData] = WDC.getMeterRawDataPoint(id)
    for(parsed <- arrayFive) {
      println(parsed.getDelivery_charge())
      println(parsed.getEnd_date())
      println(parsed.getFuel_charge())
      println(parsed.getTotal_charge())
      println(parsed.getStart_date())
      println(parsed.getGallons())
      println(parsed.getKwh())
    }



    val arraySix: Array[WegoDataRawData] = WDC.getMeterRawDatum(id)
    for(parsed <- arraySix) {
      println(parsed.getDelivery_charge())
      println(parsed.getEnd_date())
      println(parsed.getFuel_charge())
      println(parsed.getTotal_charge())
      println(parsed.getStart_date())
      println(parsed.getGallons())
      println(parsed.getKwh())
      println(parsed.getBtu())
      println(parsed.getDemand_charge())
      println(parsed.getDemand_kw())
      println(parsed.getFixed_charge())
      println(parsed.getOff_peak_charge())
      println(parsed.getOff_peak_kwh())
      println(parsed.getPeak_charge())
      println(parsed.getPeak_kwh())

    }

    }


    //wegodatawith id



    //getViewlogin
    //data.getId();
    //data.getStatus();
    //data.getUsername();
    //data.getUtility_company().getName();
    //data.getAccount_numbers();

    //getMeterRawData
//    parsed.getDelivery_charge();
//                    parsed.getEnd_date();
//                    parsed.getFuel_charge();
//                    parsed.getTotal_charge();
//                    parsed.getStart_date();
//                    parsed.getGallons();
//                    parsed.getKwh();
//                    parsed.getBtu();
//                    parsed.getDemand_charge();
//                    parsed.getDemand_kw();
//                    parsed.getFixed_charge();
//                    parsed.getOff_peak_charge();
//                    parsed.getOff_peak_kwh();
//                    parsed.getPeak_charge();
//                    parsed.getPeak_kwh();
//

    //getmeterrawdatapoint
//    data.getDelivery_charge();
//            data.getEnd_date();
//          data.getFuel_charge();
//            data.getTotal_charge();
//           data.getStart_date();
//            data.getGallons();
//            data.getKwh();

    //getmeterrawdatum


//          data.getDelivery_charge();
//          data.getEnd_date();
//          data.getFuel_charge();
//          data.getTotal_charge();
//          data.getStart_date();
//          data.getGallons();
//          data.getKwh();
//          data.getBtu();
//          data.getDemand_charge();
//          data.getDemand_kw();
//          data.getFixed_charge();
//          data.getOff_peak_charge();
//          data.getOff_peak_kwh();
//          data.getPeak_charge();
//          data.getPeak_kwh();

}



