package com.joulebug.readability;

import com.google.gson.Gson;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

/**
 * Created by shraddharathod on 7/16/15.
 *
 */
public class WegoDataClient {
    private static final String PROTECTED_RESOURCE_URL = "https://www.wegowise.com/api/v1/wego_data/";

    private String oauthKey;
    private String oauthSecret;
    private Verifier verifier;
    private Token requestToken;
    private Token accessToken;
    private Integer ID;

    public WegoDataClient(String key, String secret) {
        this.oauthKey = key;
        this.oauthSecret = secret;

    }

    public void run() {
        OAuthService service = new ServiceBuilder()
                .provider(WegowiseApi.class)
                .apiKey(this.oauthKey)
                .apiSecret(this.oauthSecret)
                .build();
        Request(service);
        Verification();
        Access(service);
        getDataOnlyMeter(service);
        getWegoDataMeterWithID(service, ID);
        getViewLogin(service, ID);
        getMeterRawData(service, ID);
        getMeterRawDataPoint(service, ID);
        getMeterRawDatum(service, ID);
    }

    public void Request(OAuthService service) {

        System.out.println("=== Wegowise's OAuth Workflow ===");
        System.out.println();

        // Obtain the Request Token
        System.out.println("Fetching the Request Token...");
        Token requestToken = service.getRequestToken();
        System.out.println("Got the Request Token! " + requestToken.toString());

        System.out.println("Now go and authorize Scribe here:");
        System.out.println(service.getAuthorizationUrl(requestToken));
        this.requestToken = requestToken;

    }

    //Verifier
    public void Verification() {
        Scanner in = new Scanner(System.in);
        System.out.println("And paste the verifier here");
        System.out.print(">>");
        Verifier verifier = new Verifier(in.nextLine());
        System.out.println();
        this.verifier = verifier;

    }

    // Trade the Request Token and Verifier for the Access Token
    public void Access(OAuthService service) {
        System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(requestToken, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();
        this.accessToken = accessToken;
    }
    // Reading the code
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

    public WegoDataMeter[] getDataOnlyMeter(OAuthService service) {
        WegoDataMeter[] result = null;
//        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL + "meters");
        service.signRequest(accessToken, request);
        Response response = request.send();
        //System.out.println("Here is your data: ");
        //System.out.println(response.getBody());

        //System.out.println("The status code:" + response.getCode());

        if (response.isSuccessful()) {
            Gson gson = new Gson();
            String json = response.getBody();

            WegoDataMeter[] data = gson.fromJson(json, WegoDataMeter[].class);
            for (WegoDataMeter parsed : data) {
                parsed.getCoverage();
                parsed.getData_type();
                parsed.getFor_heating();
                this.ID = parsed.getId();
                parsed.getNotes();
                parsed.getUtility_company().getId();
                parsed.getUtility_company().getName();


            }
            result = data;
        } else {
            System.out.println("Status Code is: " + response.getCode());
        }
        System.out.println();
        return result;
    }
    public WegoDataMeter getWegoDataMeterWithID(OAuthService service, Integer IDin) {
        WegoDataMeter result = null;
//        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL + "meters/" + IDin);
        service.signRequest(accessToken, request);
        Response response = request.send();
//        System.out.println("Here is your data: ");
//        System.out.println(response.getBody());
//
//        System.out.println("The status code:" + response.getCode());

        if (response.isSuccessful()) {
            Gson gson = new Gson();
            String json = response.getBody();

            WegoDataMeter data = gson.fromJson(json, WegoDataMeter.class);

            data.getCoverage();
            data.getData_type();
            data.getFor_heating();
            data.getId();
            data.getNotes();
            data.getUtility_company().getId();
            data.getUtility_company().getName();

            result = data;

        } else {
            System.out.println("Status Code is: " + response.getCode());
        }
        System.out.println();

        return result;

    }
    public ViewUtilityLogin getViewLogin(OAuthService service, Integer IDin) {
        ViewUtilityLogin result = null;
//        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL + "utility_logins/" + IDin);
        service.signRequest(accessToken, request);
        Response response = request.send();
//        System.out.println("Here is your data: ");
//        System.out.println(response.getBody());
//
//        System.out.println("The status code:" + response.getCode());

        if (response.isSuccessful()) {
            Gson gson = new Gson();
            String json = response.getBody();

            ViewUtilityLogin data = gson.fromJson(json, ViewUtilityLogin.class);

            data.getId();
            data.getStatus();
            data.getUsername();
            data.getUtility_company().getName();
            data.getAccount_numbers();

            result = data;

        } else {
            System.out.println("Status Code is: " + response.getCode());
        }
        System.out.println();

        return result;
    }
    /*
 {
    "delivery_charge": null,
    "end_date": "2014-01-31",
    "fuel_charge": null,
    "total_charge": "10.0",
    "start_date": "2014-01-01",
    "gallons": null,
    "kwh": "0.292997363023733",
    "btu": 1000,
    "demand_charge": null,
    "demand_kw": null,
    "fixed_charge": null,
    "off_peak_charge": null,
    "off_peak_kwh": null,
    "peak_charge": null,
    "peak_kwh": null,
  }
 */

    public WegoDataRawData[] getMeterRawData (OAuthService service, Integer IDin) {
        WegoDataRawData[] result = null;
//        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL + "meters/" + IDin + "/raw_data");
        service.signRequest(accessToken, request);
        Response response = request.send();
//        System.out.println("Here is your data: ");
//        System.out.println(response.getBody());
//
//        System.out.println("The status code:" + response.getCode());

        if (response.isSuccessful()) {
            Gson gson = new Gson();
            String json = response.getBody();

            WegoDataRawData[] data = gson.fromJson(json, WegoDataRawData[].class);

            for (WegoDataRawData parsed : data) {
                parsed.getDelivery_charge();
                parsed.getEnd_date();
                parsed.getFuel_charge();
                parsed.getTotal_charge();
                parsed.getStart_date();
                parsed.getGallons();
                parsed.getKwh();
                parsed.getBtu();
                parsed.getDemand_charge();
                parsed.getDemand_kw();
                parsed.getFixed_charge();
                parsed.getOff_peak_charge();
                parsed.getOff_peak_kwh();
                parsed.getPeak_charge();
                parsed.getPeak_kwh();
            }
            result = data;

        } else {
            System.out.println("Status Code is: " + response.getCode());
        }
        System.out.println();
        return result;

    }
    public WegoDataRawData getMeterRawDataPoint (OAuthService service, Integer IDin) {
        WegoDataRawData result = null;
//        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL + "meters/" + IDin + "/raw_data/" + IDin);
        service.signRequest(accessToken, request);
        Response response = request.send();
//        System.out.println("Here is your data: ");
//        System.out.println(response.getBody());
//
//        System.out.println("The status code:" + response.getCode());

        if (response.isSuccessful()) {
            Gson gson = new Gson();
            String json = response.getBody();

            WegoDataRawData data = gson.fromJson(json, WegoDataRawData.class);

            data.getDelivery_charge();
            data.getEnd_date();
            data.getFuel_charge();
            data.getTotal_charge();
            data.getStart_date();
            data.getGallons();
            data.getKwh();
            data.getBtu();
            data.getDemand_charge();
            data.getDemand_kw();
            data.getFixed_charge();
            data.getOff_peak_charge();
            data.getOff_peak_kwh();
            data.getPeak_charge();
            data.getPeak_kwh();

            result = data;
        } else {
            System.out.println("Status Code is: " + response.getCode());
        }
        System.out.println();

        return result;

    }
    public WegoDataRawData getMeterRawDatum (OAuthService service, Integer IDin) {
        WegoDataRawData result = null;
//        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL + "meters/" + IDin + "/latest_datum");
        service.signRequest(accessToken, request);
        Response response = request.send();
//        System.out.println("Here is your data: ");
//        System.out.println(response.getBody());
//
//        System.out.println("The status code:" + response.getCode());

        if (response.isSuccessful()) {
            Gson gson = new Gson();
            String json = response.getBody();

            WegoDataRawData data = gson.fromJson(json, WegoDataRawData.class);

            data.getDelivery_charge();
            data.getEnd_date();
            data.getFuel_charge();
            data.getTotal_charge();
            data.getStart_date();
            data.getGallons();
            data.getKwh();
            data.getBtu();
            data.getDemand_charge();
            data.getDemand_kw();
            data.getFixed_charge();
            data.getOff_peak_charge();
            data.getOff_peak_kwh();
            data.getPeak_charge();
            data.getPeak_kwh();

            result = data;
        } else {
            System.out.println("Status Code is: " + response.getCode());
        }
        System.out.println();
        return result;

    }

}

