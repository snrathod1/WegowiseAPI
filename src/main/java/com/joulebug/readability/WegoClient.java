package com.joulebug.readability;

import com.google.gson.Gson;
import com.joulebug.readability.*;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

/**
 * This WegoClient program authorizes access to WegoWise's API from which it receives and parses data.
 *
 * @author Shraddha Rathod
 * @since 8/14/15.
 */
public class WegoClient {

    private static final String PROTECTED_RESOURCE_URL = "https://www.wegowise.com/";

    private String oauthKey;
    private String oauthSecret;
    private Verifier verifier;
    private Token requestToken;
    public Token accessToken;
    public OAuthService service;


    public WegoClient(String key, String secret) {
        this.oauthKey = key;
        this.oauthSecret = secret;
        this.service = new ServiceBuilder()
                .provider(WegowiseApi.class)
                .apiKey(this.oauthKey)
                .apiSecret(this.oauthSecret)
                .build();
    }
    //token request, verification, and data retrieval; parsing data
    /*
     * This method runs the Request, Verification, and Access methods. This is to authorize access.
     * @parameters none
     */
    public void run() {
        Request();
        Verification();
        Access();
    }
    /*
    * This method requests a token from Wegowise and if obtained, requests user to authorize Scribe with a link.
    * @parameters: none
     */
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

    /*
     * In this method, the user pastes the verification code obtained from authorization in the Request method.
     * @parameters: none
     */
    public void Verification() {
        Scanner in = new Scanner(System.in);
        System.out.println("And paste the verifier here");
        System.out.print(">>");
        Verifier verifier = new Verifier(in.nextLine());
        System.out.println();
        this.verifier = verifier;

    }
    /*
     * In this method, the request token and the verifier are traded for the access token
     * @param none
     */

    public void Access() {
        Token accessToken = this.service.getAccessToken(requestToken, verifier);
        //Got the access token
        System.out.println();
        this.accessToken = accessToken;
    }

    /*
     * In this method, the request token and the verifier are traded for the access token
     * @param name - this class where the data is parsed
     * @param String - the end of the url to access the data in Wegowise
     * @return parsed data
     */
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


}
