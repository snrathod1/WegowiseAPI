package com.joulebug.readability

import com.google.gson.Gson

/**
 * Created by shraddharathod on 6/30/15.
 */
object UpdateMeterTest {
  def UMTest(): Unit = {

    val gson = new Gson()
    val json = "{\n    \"for_heating\": false\n}"
    val parsed = gson.fromJson(json, new UpdateMeter().getClass)

    println("Is there heating? " + parsed.getFor_heating())


  }

}
