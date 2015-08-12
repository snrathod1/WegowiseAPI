package com.joulebug.readability.WegoHome;

import com.google.gson.Gson;
import com.joulebug.readability.*;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

/**
 * Created by shraddharathod on 8/12/15.
 */
public class WegoHomeClient {
    private static final String PROTECTED_RESOURCE_URL = "https://www.wegowise.com/";

    private String oauthKey;
    private String oauthSecret;
    private Verifier verifier;
    private Token requestToken;
    public Token accessToken;
    public OAuthService service;


    //input key and secret from your app
    public WegoHomeClient(String key, String secret) {
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
        System.out.println(response.getBody());
        //if response results in a 200 code
        if (response.isSuccessful()) {
            try {
                Gson gson = new Gson();
                String json = response.getBody();
                T data = gson.fromJson(json, name);     //parses Json
                return data;

            } catch (com.google.gson.JsonSyntaxException e) {
                System.out.println("Invalid JSon");

            } catch (NullPointerException e) {
                System.out.println("Invalid data");
            }
        } else {
            if (response != null) {
                try {
                    Gson gSon = new Gson();
                    String jSon = response.getBody();
                    WegoViewMeterError message = gSon.fromJson(jSon, WegoViewMeterError.class);   //error message from Wego
                    throw new RuntimeException("An error from Wegowise occured: " + message.getErrors());
                } catch (com.google.gson.JsonSyntaxException e) {
                    System.out.println("Json Error");

                } catch (NullPointerException e) {
                    System.out.println("Invalid data");
                }

            }  else {
                System.out.println("Status Code is: " + response.getCode());           //what went wrong
                System.out.println("Something went wrong: Could be that you are offline, Wegowise is down, etc.");

            }
        }
        return result;
    }
    //Parsing the code

    public WegoOAuthUser getWegoOAuthUser() {
        System.out.println("OAuth User: ");
        return get(WegoOAuthUser.class, "oauth/user");


    }
    public BuildingDetails getBuildingDetails() {
        System.out.println("Building Details: ");
        return get(BuildingDetails.class, "api/v1/wego_home/building");

    }
    public HomeMeterList[] getHomeMeterList() {
        System.out.println("List of Meters: ");
        return get(HomeMeterList[].class, "api/v1/wego_home/meters");

    }


    public HomeRawDataByMeter[] getHomeRawDataByMeter (Integer IDin) {
        System.out.println("Raw Data by Meter: ");
        return get(HomeRawDataByMeter[].class, "api/v1/wego_home/meters/" + IDin + "/raw_data");

    }

}

