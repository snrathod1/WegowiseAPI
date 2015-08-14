package com.joulebug.readability.WegoData;

import com.google.gson.Gson;
import com.joulebug.readability.WegoClient;
import com.joulebug.readability.WegoHome.WegoOAuthUser;
import com.joulebug.readability.WegoViewMeterError;
import com.joulebug.readability.WegowiseApi;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

/**
 * This class receives authorization to use the Wegowise API and parses data from WegoData.
 * @author shraddharathod
 * @since 7/16/15.
 *
 */

public class WegoDataClient {
    /*
     * This method receives authorization to use the Wegowise API
     */
    public WegoDataClient(WegoClient myWegoClient) {
        myWegoClient.run();
    }
    /*
    * This method gets data from all of the meters owned
    * @param myWegoClient to use the get method to parse data
    * @return parsed data of your meters
     */
    public WegoDataMeter[] getDataOnlyMeter(WegoClient myWegoClient) {
        System.out.println("DataOnlyMeter: ");
        return myWegoClient.get(WegoDataMeter[].class, "api/v1/wego_data/meters");


    }
    /*
    * This method gets data of a certain meter with a ID.
    * @param myWegoClient to use the get method to parse data
    * @param IDin is the ID of your meter
    * @return parsed data of that particular meter
     */
    public WegoDataMeter getWegoDataMeterWithID(WegoClient myWegoClient, Integer IDin) {
        System.out.println("DataMeterWithID: ");
        return myWegoClient.get(WegoDataMeter.class, "api/v1/wego_data/meters/" + IDin);

    }
    /*
    * This method gets utility login information of a specific meter with ID.
    * @param myWegoClient to use the get method to parse data
    * @param IDin is the ID of your meter
    * @return parsed utility login data of that particular meter
     */
    public ViewUtilityLogin getViewLogin(WegoClient myWegoClient, Integer IDin) {
        return myWegoClient.get(ViewUtilityLogin.class, "api/v1/wego_data/utility_logins/" + IDin);

    }

    /*
    * This method gets all the raw data of a specific meter with ID
    * @param myWegoClient to use the get method to parse data
    * @param IDin is the ID of your meter
    * @return parsed meter data of that particular meter across time points
     */
    public WegoRawDataPoint[] getMeterRawData (WegoClient myWegoClient, Integer IDin) {
        System.out.println("MeterRawData: ");
        return myWegoClient.get(WegoRawDataPoint[].class, "api/v1/wego_data/meters/" + IDin + "/raw_data");


    }
    /*
    * This method gets the data from a particular meter with ID at a certain time point/
    * @param myWegoClient to use the get method to parse data
    * @param IDin is the ID of your meter
    * @param IDinn is the ID of that data point
    * @return parsed data of that particular meter at a certain time point
     */
    public WegoRawDataPoint getMeterRawDataPoint (WegoClient myWegoClient, Integer IDin, Integer IDinn) {
        System.out.println("MeterRawDataPoint: ");
        return myWegoClient.get(WegoRawDataPoint.class, "api/v1/wego_data/meters/" + IDin + "/raw_data/" + IDinn);

    }
    /*
    * This method gets the data from a particular meter with ID at the latest time period
    * @param myWegoClient to use the get method to parse data
    * @param IDin is the ID of your meter
    * @return parsed data of that particular meter at the lastest time point
     */
    public WegoRawDataPoint getMeterRawDatum (WegoClient myWegoClient, Integer IDin) {
        System.out.println("MeterRawDatum: ");
        return myWegoClient.get(WegoRawDataPoint.class, "api/v1/wego_data/meters/" + IDin + "/latest_datum");


    }
}