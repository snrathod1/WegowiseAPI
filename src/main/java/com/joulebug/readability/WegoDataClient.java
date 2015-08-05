package com.joulebug.readability;

import com.google.gson.Gson;
import org.scribe.builder.ServiceBuilder;
import org.scribe.exceptions.OAuthException;
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
    private Integer ID;

    //input key and secret from your app
    public WegoDataClient(String key, String secret) {
        this.oauthKey = key;
        this.oauthSecret = secret;

    }
    //token request, verification, and data retrieval; parsing data
    public void run() {
        OAuthService service = new ServiceBuilder()
                .provider(WegowiseApi.class)
                .apiKey(this.oauthKey)
                .apiSecret(this.oauthSecret)
                .build();
        Request(service);
        Verification();
        Access(service);
        getDataOnlyMeter();
        getWegoDataMeterWithID();
        getViewLogin();
        getMeterRawData();
        getMeterRawDataPoint();
        getMeterRawDatum();
    }
    //Request
    public void Request(OAuthService service) {

        System.out.println("=== Wegowise's OAuth Workflow ===");
        System.out.println();

        // Obtain the Request Token
        //System.out.println("Fetching the Request Token...");
        Token requestToken = service.getRequestToken();
        if (requestToken == null) {
            System.out.println("We could not obtain the request token.");
            System.exit(0);

        }
        //System.out.println("Got the Request Token! " + requestToken.toString());
        else {
            System.out.println("Now go and authorize Scribe here:");
            System.out.println(service.getAuthorizationUrl(requestToken));
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
    public void Access(OAuthService service) {
        //System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(requestToken, verifier);

       /*
        try {
            Token accessToken = service.getAccessToken(requestToken, verifier);
        } catch (OAuthException e) {
            System.out.println(e.getMessage());
        }
        **/
        //System.out.println("Got the Access Token!");
        //System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();
        this.accessToken = accessToken;
    }

    protected<T> T get(OAuthService service,Class<T> name, String end) {
        T result = null;
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL + end);
        service.signRequest(accessToken, request);
        Response response = request.send();

        if (response.isSuccessful()) {
            Gson gson = new Gson();
            String json = response.getBody();
            T data = gson.fromJson(json, name);
            return data;
        } else {
            System.out.println("Status Code is: " + response.getCode());
            Gson gSon = new Gson();
            String jSon = response.getBody();
            WegoViewMeterError message = gSon.fromJson(jSon, WegoViewMeterError.class);
        }
        return result;
    }
    //Parsing the code

    public WegoDataMeter[] getDataOnlyMeter() {
        System.out.println("DataOnlyMeter: ");
        return get(service, WegoDataMeter[].class, "meters", null);
////            for (WegoDataMeter parsed : data) {
////                parsed.getCoverage();
////                parsed.getData_type();
////                parsed.getFor_heating();
////                this.ID = parsed.getId();
////                parse
////                parsed();
////                parseame();
////
////

    }
    public WegoDataMeter getWegoDataMeterWithID(Integer IDin) {
        System.out.println("DataMeterWithID: ");
        return get(service, WegoDataMeter.class, "meters" + IDin);


           // data.getCoverage();
           // data.getData_type();
           // data.getFor_heating();
            //data.getId();
            //data.getNotes();
           // data.getUtility_company().getId();
//            data.getUtility_company().getName();

    }
    public ViewUtilityLogin getViewLogin(Integer IDin) {
        return get(service, ViewUtilityLogin.class, "utility_logins/" + IDin);


            //data.getId();
            //data.getStatus();
            //data.getUsername();
            //data.getUtility_company().getName();
            //data.getAccount_numbers();

    }


    public WegoDataRawData[] getMeterRawData (Integer IDin) {
        System.out.println("MeterRawData: ");
        return get(service, WegoDataRawData[].class, "meters/" + IDin + "/raw_data");

                /*parsed.getDelivery_charge();
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
                **/

    }
    public WegoDataRawData getMeterRawDataPoint (Integer IDin) {
        System.out.println("MeterRawDataPoint: ");
        return get(service, WegoDataRawData.class, "meters/" + IDin + "/raw_data" + IDin);


            /*data.getDelivery_charge();
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
            **/


    }
    public WegoDataRawData getMeterRawDatum (Integer IDin) {
        System.out.println("MeterRawDatum: ");
        return get(service, WegoDataRawData.class, "meters/" + IDin + "/latest_datum");

/*
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
            **/

    }

}

