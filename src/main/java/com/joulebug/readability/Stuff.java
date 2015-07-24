package com.joulebug.readability;

/**
 * Created by shraddharathod on 7/17/15.
 */

public class Stuff {
    //basic outline for usage

    //create client
    // wego = new WegoDataClient(key,secret)
    //
    //authorize
    //wego.authorize()
    //
    //get some data
    //val meter = wego.getMeter(id)
    //meter should be of "DataOnlyMeter" class
    //repeat for other URLs in WegoData (GET Requests only for now)

    //basic steps:
    //construct URL (using base url)
    //execute request
    //receive response body -(string)
    //(handle errors)
    //parse response JSON to Java object
    //return java object

}
