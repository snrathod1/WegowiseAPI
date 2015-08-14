package com.joulebug.wegowise.WegoData;

import com.joulebug.wegowise.WegoClient;

/**
 * This class receives authorization to use the Wegowise API and parses data from WegoData.
 * @author shraddharathod
 * @since 7/16/15.
 *
 */

public class WegoDataClient extends WegoClient {


    WegoDataClient(String key, String secret) {
        super(key,secret);
    }

    /*
    * This method gets data from all of the meters owned
    * @return parsed data of your meters
     */
    public WegoDataMeter[] getDataOnlyMeter() {
        System.out.println("DataOnlyMeter: ");
        return get(WegoDataMeter[].class, "api/v1/wego_data/meters");

    }

    /*
    * This method gets data of a certain meter with a ID.
    * @param IDin is the ID of your meter
    * @return parsed data of that particular meter
     */
    public WegoDataMeter getWegoDataMeterWithID(Integer IDin) {
        System.out.println("DataMeterWithID: ");
        return get(WegoDataMeter.class, "api/v1/wego_data/meters/" + IDin);

    }

    /*
    * This method gets utility login information of a specific meter with ID.
    * @param IDin is the ID of your meter
    * @return parsed utility login data of that particular meter
     */
    public ViewUtilityLogin getViewLogin(Integer IDin) {
        return get(ViewUtilityLogin.class, "api/v1/wego_data/utility_logins/" + IDin);

    }

    /*
    * This method gets all the raw data of a specific meter with ID
    * @param IDin is the ID of your meter
    * @return parsed meter data of that particular meter across time points
     */
    public WegoRawDataPoint[] getMeterRawData (Integer IDin) {
        System.out.println("MeterRawData: ");
        return get(WegoRawDataPoint[].class, "api/v1/wego_data/meters/" + IDin + "/raw_data");


    }

    /*
    * This method gets the data from a particular meter with ID at a certain time point/
    * @param myWegoClient to use the get method to parse data
    * @param IDin is the ID of your meter
    * @param IDinn is the ID of that data point
    * @return parsed data of that particular meter at a certain time point
     */
    public WegoRawDataPoint getMeterRawDataPoint (Integer IDin, Integer IDinn) {
        System.out.println("MeterRawDataPoint: ");
        return get(WegoRawDataPoint.class, "api/v1/wego_data/meters/" + IDin + "/raw_data/" + IDinn);

    }

    /*
    * This method gets the data from a particular meter with ID at the latest time period
    * @param IDin is the ID of your meter
    * @return parsed data of that particular meter at the latest time point
     */
    public WegoRawDataPoint getMeterRawDatum (Integer IDin) {
        System.out.println("MeterRawDatum: ");
        return get(WegoRawDataPoint.class, "api/v1/wego_data/meters/" + IDin + "/latest_datum");


    }
}