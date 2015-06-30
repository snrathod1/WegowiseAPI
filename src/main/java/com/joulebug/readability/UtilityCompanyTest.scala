package com.joulebug.readability
import com.google.gson.Gson
/**
 * Created by shraddharathod on 6/30/15.
 */
/*
{
    "id": 23,
    "data_type": "Gas",
    "name": "Con Edison",
    "short_name": "ConEd",
    "state_code": "PA"
  }
 */
object UtilityCompanyTest {
  def UCTest(): Unit = {

    val gson = new Gson()
    val json = "{\n    \"id\": 23,\n    \"data_type\": \"Gas\",\n    \"name\": \"Con Edison\",\n    \"short_name\": \"ConEd\",\n    \"state_code\": \"PA\"\n}"
    val parsed = gson.fromJson(json, new UtilityCompany().getClass)

    println("The ID is " + parsed.getId() + ".")
    println("The data type is " + parsed.getData_type() + ".")
    println("The name of the utility company is " + parsed.getShort_name() + ".")
    println("The state abbreviation is " + parsed.getState_code + ".")

  }

  //object - single thing
  //UtilityCompanyTest.UCTest()

  //class - object 'factory'
  //new UtilityCompany().method()
}




