package com.joulebug.readability.WegoHome

//import com.joulebug.readability.{WegoHomeClient}

/**
 * Created by shraddharathod on 8/12/15.
 */
object WegoHomeClientTest {

  def WHCTest() {

    val WHC = new WegoHomeClient("your key", "your secret")

    WHC.run()

    val wegoOAuthUser = WHC.getWegoOAuthUser()

    println("ID: " + wegoOAuthUser.getId())
    println("Username: " + wegoOAuthUser.getUsername())

  try {
    val buildingDetails = WHC.getBuildingDetails()

    println("The conditioned square-footage is" + buildingDetails.getConditioned_sqft() + ".")
    println("The ID is " + buildingDetails.getId() + ".")
    println("The nickname is " + buildingDetails.getNickname())
    println("The number of stories is " + buildingDetails.getN_stories() + ".")
    println("The square-footage is " + buildingDetails.getSqft() + ".")
    println("The year built is " + buildingDetails.getYear_built() + ".")
    println("The type is " + buildingDetails.getType() + ".")
    println("The basement square-footage is " + buildingDetails.getBasement().getSqft() + ".")
    println("Is the basement conditioned? " + buildingDetails.getBasement().getConditioned() + ".")
    println("The cooling system is " + buildingDetails.getCooling().getSystem() + ".")
    println("The heating fuel is " + buildingDetails.getHeating().getFuel() + ".")
    println("The heating system is " + buildingDetails.getHeating().getSystem + ".")
    println("The hot water fuel is " + buildingDetails.getHot_water.getFuel() + ".")
    println("The hot water system is " + buildingDetails.getHot_water().getSystem() + ".")
    println("The city is " + buildingDetails.getLocation().getCity() + ".")
    println("The climate zone is " + buildingDetails.getLocation().getClimate_zone() + ".")
    println("The country is " + buildingDetails.getLocation().getCountry() + ".")
    println("The county is " + buildingDetails.getLocation.getCounty() + ".")
    println("The state is " + buildingDetails.getLocation.getState() + ".")
    println("The street address is " + buildingDetails.getLocation.getStreet_address() + ".")
    println("The zip code is " + buildingDetails.getLocation.getZip_code() + ".")
  } catch {
    case e: Exception => println("Something went wrong!" + e.toString())
  }

      val homeMeterList: Array[HomeMeterList] = WHC.getHomeMeterList()

      for (parsed <- homeMeterList) {
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


      val homeRawDataByMeter: Array[HomeRawDataByMeter] = WHC.getHomeRawDataByMeter(homeMeterList.head.getId)

      for (parsed <- homeRawDataByMeter) {
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
