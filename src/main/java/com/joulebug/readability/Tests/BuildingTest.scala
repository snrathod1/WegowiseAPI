package com.joulebug.readability.Tests

import com.google.gson.Gson
import com.joulebug.readability.WegoHome.Building

/**
 * Created by shraddharathod on 7/7/15.
 */
/**
 * {
 "address": "123 Main St, Boston, MA 02118",
 "nickname": "Main Street Apartments",
 "building_type": "sf_detached",
 "year_built": "2000",
 "construction": "wood_steel",
 "sqft": "1000",
 "has_basement": true,
 "basement_sqft": "200",
 "basement_conditioned": false,
 "n_stories": "2",
 "n_bedrooms": "12",
 "green_certified": false,
 "n_electric_general_meters": "1",
 "n_water_general_meters": "1",
 "n_gas_general_meters": "1",
 "n_oil_general_meters": "0",
 "heating_system": "furnace",
 "heating_fuel": "Gas",
 "cooling_system": "window_ac",
 "hot_water_fuel": "Solar",
 "hot_water_system": "other",
 "has_pool": "false",
 "has_laundry": "false",
 "notes": "notes",
 "draft": false
 }
 */
object BuildingTest {
  def BTest(): Unit = {
    println("Please enter the data file:")
    val name = Console.readLine

    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString
    val array: Array[Building] = gson.fromJson(json, Array[Building]().getClass)



    for (parsed <- array) {

      println("The address is " + parsed.getAddress() + ".")
      println("The nickname is " + parsed.getNickname() + ".")
      println("The building type is " + parsed.getBuilding_type() + ".")
      println("The year built is" + parsed.getYear_built() + ".")
      println("The construction is " + parsed.getConstruction() + ".")
      println("The square-footage is " + parsed.getSqft() + ".")
      println("Does it have a basement? " + parsed.getHas_basement() + ".")
      println("The basement square-footage is " + parsed.getBasement_sqft() + ".")
      println("Is the basement conditioned? " + parsed.getBasement_conditioned() + ".")
      println("The number of stories is " + parsed.getN_stories() + ".")
      println("The number of bedrooms is " + parsed.getN_bedrooms() + ".")
      println("Is it green-certified? " + parsed.getGreen_certified() + ".")
      println("The number of electric general meters is " + parsed.getN_electric_general_meters() + ".")
      println("The number of water general meters is " + parsed.getN_water_general_meters() + ".")
      println("The number of gas general meters is " + parsed.getN_gas_general_meters() + ".")
      println("The number of oil general meters is " + parsed.getN_oil_general_meters() + ".")
      println("The heating system is " + parsed.getHeating_system() + ".")
      println("The heating fuel is " + parsed.getHeating_fuel() + ".")
      println("The cooling system is " + parsed.getCooling_system() + ".")
      println("The hot water fuel is " + parsed.getHot_water_fuel() + ".")
      println("The hot water system is " + parsed.getHot_water_system() + ".")
      println("Does it have a pool? " + parsed.getHas_pool() + ".")
      println("Does it have laundry? " + parsed.getHas_laundry() + ".")
      println("Notes: " + parsed.getNotes() + ".")
      println("Does it have a draft? " + parsed.getDraft() + ".")
    }
  }

}
