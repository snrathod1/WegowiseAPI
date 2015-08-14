package com.joulebug.wegowise;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 * Created by shraddharathod on 7/10/15.
 */
public class WegowiseApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "https://www.wegowise.com/oauth/authorize?oauth_token=%s";

    @Override
    public String getAccessTokenEndpoint()
    {
        return "https://www.wegowise.com/oauth/access_token";
    }

    @Override
    public String getRequestTokenEndpoint()
    {
        return "https://www.wegowise.com/oauth/request_token";
    }

    @Override
    public String getAuthorizationUrl(Token requestToken)
    {
        return String.format(AUTHORIZATION_URL, requestToken.getToken());
    }
}

