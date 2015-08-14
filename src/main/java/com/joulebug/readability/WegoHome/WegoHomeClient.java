package com.joulebug.readability.WegoHome;

import com.google.gson.Gson;
import com.joulebug.readability.*;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

/**
 * This class receives authorization to use the Wegowise API and parses data from WegoHome.
 * @author shraddharathod
 * @since 8/12/15.
 */
public class WegoHomeClient {

    public WegoHomeClient(WegoClient myWegoClient) {
        myWegoClient.run();
    }

    /*
    * This method shows the OAuth user.
    * @param myWegoClient to use the get method to parse data
    * @return parsed OAuth user data
     */
    public WegoOAuthUser getWegoOAuthUser(WegoClient myWegoClient) {
        System.out.println("OAuth User: ");
        return myWegoClient.get(WegoOAuthUser.class, "oauth/user");


    }
    /*
    * This method shows the Building details.
    * @param myWegoClient to use the get method to parse data
    * @return parsed BUilding details data
     */
    public BuildingDetails getBuildingDetails(WegoClient myWegoClient) {
        System.out.println("Building Details: ");
        return myWegoClient.get(BuildingDetails.class, "api/v1/wego_home/building");

    }
    /*
    * This method shows a list of meters in your home.
    * @param myWegoClient to use the get method to parse data
    * @return parsed home meter list
     */
    public HomeMeterList[] getHomeMeterList(WegoClient myWegoClient) {
        System.out.println("List of Meters: ");
        return myWegoClient.get(HomeMeterList[].class, "api/v1/wego_home/meters");

    }

    /*
    * This method shows the OAuth user.
    * @param myWegoClient to use the get method to parse data
    * @return parsed OAuth user data
     */
    public HomeRawDataByMeter[] getHomeRawDataByMeter (WegoClient myWegoClient, Integer IDin) {
        System.out.println("Raw Data by Meter: ");
        return myWegoClient.get(HomeRawDataByMeter[].class, "api/v1/wego_home/meters/" + IDin + "/raw_data");

    }

}

