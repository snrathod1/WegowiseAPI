package com.joulebug.readability;

/**
 * Created with IntelliJ IDEA.
 * User: josephelliott
 * Date: 12/19/13
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
public class RequestParameter {

    String key;
    String value;

    public RequestParameter(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
