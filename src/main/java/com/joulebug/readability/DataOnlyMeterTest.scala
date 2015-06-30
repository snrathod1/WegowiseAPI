package com.joulebug.readability
import com.google.gson.Gson
/*
{
    "coverage": "none",
    "data_type": "Gas",
    "for_heating": false,
    "id": 1,
    "notes": "Some notes",
    "utility_company":
      {
        "id": 1,
        "name": "UtilityCo1"
      }
  }
 */
/**
 * Created by shraddharathod on 6/30/15.
 */
object DataOnlyMeterTest {
  def DOMTest (): Unit = {
    val gson = new Gson()
    val json = "{\n    \"coverage\": \"none\",\n    \"data_type\": \"Gas\",\n    \"for_heating\": false,\n    \"id\": 1,\n    \"notes\": \"Some notes\",\n    \"utility_company\":\n      {\n        \"id\": 1,\n        \"name\": \"UtilityCo1\"\n      }\n  }"
    val parsed = gson.fromJson(json, new DataOnlyMeter().getClass)

    println("The coverage is " + parsed.getCoverage() + ".")
    println("The data type is " + parsed.getData_type() + ".")
    println("Is it for heating? " + parsed.getFor_heating())
    println("The ID is " + parsed.getId() + ".")
    println("The utility company ID is " + parsed.getUtility_company().getId() + ".")
    println("The name of the utility company is " + parsed.getUtility_company.getName() + ".")

  }

}
