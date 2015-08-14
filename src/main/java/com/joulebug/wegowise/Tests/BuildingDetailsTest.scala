package com.joulebug.wegowise.Tests

import com.google.gson.Gson
import com.joulebug.wegowise.WegoHome.BuildingDetails

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
{
        "conditioned_sqft": 12000,
        "id": 1,
        "nickname": "The Big Building",
        "n_stories": 3,
        "sqft": 13000,
        "year_built": 1950,
        "type": "Low-rise apartment building",
        "basement":
        {
        "sqft": 1000,
        "conditioned": false
        },
        "cooling":
        {
        "system": "Window AC"
        },
        "heating":
        {
        "fuel": "Gas",
        "system": "Boiler (High-efficiency condensing)"
        },
        "hot_water":
        {
        "fuel": "Gas",
        "system": "Indirect hot water tank off boiler (Heat & DHW)"
        },
        "location":
        {
        "city": "Boston",
        "climate_zone": "cold",
        "country": "United States",
        "county": "Suffolk",
        "state": "MA",
        "street_address": "1 Example Street",
        "zip_code": "02201"
        }
        }
*/
object BuildingDetailsTest {
  def BDTest (): Unit = {

    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[BuildingDetails] = gson.fromJson(json, Array[BuildingDetails]().getClass)



    for (parsed <- array) {
      println("The conditioned square-footage is" + parsed.getConditioned_sqft() + ".")
      println("The ID is " + parsed.getId() + ".")
      println("The nickname is " + parsed.getNickname())
      println("The number of stories is " + parsed.getN_stories() + ".")
      println("The square-footage is " + parsed.getSqft() + ".")
      println("The year built is " + parsed.getYear_built() + ".")
      println("The type is " + parsed.getType() + ".")
      println("The basement square-footage is " + parsed.getBasement().getSqft() + ".")
      println("Is the basement conditioned? " + parsed.getBasement().getConditioned() + ".")
      println("The cooling system is " + parsed.getCooling().getSystem() + ".")
      println("The heating fuel is " + parsed.getHeating().getFuel() + ".")
      println("The heating system is " + parsed.getHeating().getSystem + ".")
      println("The hot water fuel is " + parsed.getHot_water.getFuel() + ".")
      println("The hot water system is " + parsed.getHot_water().getSystem() + ".")
      println("The city is " + parsed.getLocation().getCity() + ".")
      println("The climate zone is " + parsed.getLocation().getClimate_zone() + ".")
      println("The country is " + parsed.getLocation().getCountry() + ".")
      println("The county is " + parsed.getLocation.getCounty() + ".")
      println("The state is " + parsed.getLocation.getState() + ".")
      println("The street address is " + parsed.getLocation.getStreet_address() + ".")
      println("The zip code is " + parsed.getLocation.getZip_code() + ".")

    }
  }

}
