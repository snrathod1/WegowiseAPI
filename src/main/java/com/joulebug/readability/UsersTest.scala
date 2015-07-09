package com.joulebug.readability

import com.google.gson.Gson

/**
 * Created by shraddharathod on 7/7/15.
 */
/**
 * {
 "email": "newuser@example.com",
 "first_name": "New",
 "last_name": "User",
 "username": "newuser",
 "password": "s3kr3+",
 }
 */
object UsersTest {


  def UTest(): Unit = {
    println("Please enter the data file:")
    val name = Console.readLine
    val gson = new Gson()
    val json = scala.io.Source.fromFile(name).mkString

    val array: Array[Users] = gson.fromJson(json, Array[Users]().getClass)



    for (parsed <- array) {
      println("The email is " + parsed.getEmail() + ".")
      println("The first name is " + parsed.getFirst_name() + ".")
      println("The last name is " + parsed.getLast_name() + ".")
      println("The username is " + parsed.getUsername + ".")
      println("The password is " + parsed.getPassword + ".")

    }
  }

}
