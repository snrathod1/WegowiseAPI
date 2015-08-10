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

//gets data from WegoWise API and parses it
public class WegoDataClient {
    private static final String PROTECTED_RESOURCE_URL = "https://www.wegowise.com/api/v1/wego_data/";

    private String oauthKey;
    private String oauthSecret;
    private Verifier verifier;
    private Token requestToken;
    private Token accessToken;
    private OAuthService service;


    //input key and secret from your app
    public WegoDataClient(String key, String secret) {
        this.oauthKey = key;
        this.oauthSecret = secret;
        this.service = new ServiceBuilder()
             .provider(WegowiseApi.class)
             .apiKey(this.oauthKey)
             .apiSecret(this.oauthSecret)
             .build();

    }
    //token request, verification, and data retrieval; parsing data
    public void run() {
        Request();
        Verification();
        Access();
    }
    //Request
    public void Request() {

        System.out.println();

        // Fetches the Request Token
        Token requestToken = this.service.getRequestToken();
        if (requestToken == null) {
            System.out.println("We could not obtain the request token.");
            System.exit(0);
        }
        //Gets the request token
        else {
            System.out.println("Now go and authorize Scribe here:");
            System.out.println(this.service.getAuthorizationUrl(requestToken));
            this.requestToken = requestToken;
        }

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
    public void Access() {
        Token accessToken = this.service.getAccessToken(requestToken, verifier);
        //Got the access token
        System.out.println();
        this.accessToken = accessToken;
    }

    protected<T> T get(Class<T> name, String end) {
        T result = null;
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL + end);
        this.service.signRequest(accessToken, request);
        Response response = request.send();
        //if response results in a 200 code
        if (response.isSuccessful()) {
            try {
               Gson gson = new Gson();
               String json = response.getBody();
               T data = gson.fromJson(json, name);     //parses Json
               return data;

            } catch (com.google.gson.JsonSyntaxException e) {
                System.out.println("Invalid JSon");

            }
        } else {
            if (response != null) {
                Gson gSon = new Gson();
                String jSon = response.getBody();
                WegoViewMeterError message = gSon.fromJson(jSon, WegoViewMeterError.class);   //error message from Wego

            }  else {
                System.out.println("Status Code is: " + response.getCode());           //what went wrong
                System.out.println("Something went wrong: Could be that you are offline, Wegowise is down, etc.");

            }
        }
        return result;
    }
    //Parsing the code

    protected WegoDataMeter[] getDataOnlyMeter() {
        System.out.println("DataOnlyMeter: ");
        return get(WegoDataMeter[].class, "meters");


    }
    public WegoDataMeter[] getWegoDataMeterWithID(Integer IDin) {
        System.out.println("DataMeterWithID: ");
        return get(WegoDataMeter[].class, "meters" + IDin);

    }
    public ViewUtilityLogin[] getViewLogin(Integer IDin) {
        return get(ViewUtilityLogin[].class, "utility_logins/" + IDin);

    }


    public WegoDataRawData[] getMeterRawData (Integer IDin) {
        System.out.println("MeterRawData: ");
        return get(WegoDataRawData[].class, "meters/" + IDin + "/raw_data");


    }
    public WegoDataRawData[] getMeterRawDataPoint (Integer IDin) {
        System.out.println("MeterRawDataPoint: ");
        return get(WegoDataRawData[].class, "meters/" + IDin + "/raw_data" + IDin);

    }
    public WegoDataRawData[] getMeterRawDatum (Integer IDin) {
        System.out.println("MeterRawDatum: ");
        return get(WegoDataRawData[].class, "meters/" + IDin + "/latest_datum");


    }
}