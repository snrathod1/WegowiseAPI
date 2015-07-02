package com.joulebug.readability

import com.google.gson.Gson

/**
 * Created by shraddharathod on 6/30/15.
 */
/*
{
    "id": 1,
    "status": "success",
    "username": "abcproperties",
    "utility_company": {
        "name": "NSTAR"
    },
    "account_numbers": [
        "abc123",
        "xyz987"
    ]
}
 */
object ViewUtilityLoginTest {

  def VULTest(): Unit = {

    val gson = new Gson()
    val json = "{\n    \"id\": 1,\n    \"status\": \"success\",\n    \"username\": \"abcproperties\",\n    \"utility_company\": {\n        \"name\": \"NSTAR\"\n    },\n    \"account_numbers\": [\n        \"abc123\",\n        \"xyz987\"\n    ]\n}"
    val parsed = gson.fromJson(json, new ViewUtilityLogin().getClass)

    println("The ID is " + parsed.getId() + ".")
    println("The status is " + parsed.getStatus() + ".")
    println("The username is " + parsed.getUsername() + ".")
    println("The name of the utility company is " + parsed.getUtility_company().getName + ".")
    println("The account number(s) is(are) " + parsed.getAccount_numbers().mkString(" , ") + " .")
  }

}