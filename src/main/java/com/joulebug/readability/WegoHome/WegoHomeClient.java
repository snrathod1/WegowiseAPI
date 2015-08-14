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
public class WegoHomeClient extends WegoClient {


    WegoHomeClient(String key, String secret) {
        super(key,secret);
    }


    /*
    * This method shows the OAuth user.
    * @param myWegoClient to use the get method to parse data
    * @return parsed OAuth user data
     */
    public WegoOAuthUser getWegoOAuthUser() {
        System.out.println("OAuth User: ");
        return get(WegoOAuthUser.class, "oauth/user");


    }
    /*
    * This method shows the Building details.
    * @param myWegoClient to use the get method to parse data
    * @return parsed BUilding details data
     */
    public BuildingDetails getBuildingDetails() {
        System.out.println("Building Details: ");
        return get(BuildingDetails.class, "api/v1/wego_home/building");

    }
    /*
    * This method shows a list of meters in your home.
    * @param myWegoClient to use the get method to parse data
    * @return parsed home meter list
     */
    public HomeMeterList[] getHomeMeterList() {
        System.out.println("List of Meters: ");
        return get(HomeMeterList[].class, "api/v1/wego_home/meters");

    }

    /*
    * This method shows the OAuth user.
    * @param myWegoClient to use the get method to parse data
    * @return parsed OAuth user data
     */
    public HomeRawDataByMeter[] getHomeRawDataByMeter (Integer IDin) {
        System.out.println("Raw Data by Meter: ");
        return get(HomeRawDataByMeter[].class, "api/v1/wego_home/meters/" + IDin + "/raw_data");

    }

}

