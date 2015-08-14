package com.joulebug.wegowise.WegoHome;

import com.joulebug.wegowise.*;

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
    * @return parsed OAuth user data
     */
    public WegoOAuthUser getWegoOAuthUser() {
        System.out.println("OAuth User: ");
        return get(WegoOAuthUser.class, "oauth/user");

    }

    /*
    * This method shows the Building details.
    * @return parsed Building details data
     */
    public BuildingDetails getBuildingDetails() {
        System.out.println("Building Details: ");
        return get(BuildingDetails.class, "api/v1/wego_home/building");

    }

    /*
    * This method shows a list of meters in your home.
    * @return parsed home meter list
     */
    public HomeMeterList[] getHomeMeterList() {
        System.out.println("List of Meters: ");
        return get(HomeMeterList[].class, "api/v1/wego_home/meters");

    }

    /*
    * This method gets all the raw data of a specific meter with ID
    * @return parsed parsed meter data of that particular meter across time points
     */
    public HomeRawDataByMeter[] getHomeRawDataByMeter (Integer IDin) {
        System.out.println("Raw Data by Meter: ");
        return get(HomeRawDataByMeter[].class, "api/v1/wego_home/meters/" + IDin + "/raw_data");

    }

}

