package com.joulebug.readability;

/**
 * Created with IntelliJ IDEA.
 * User: josephelliott
 * Date: 12/19/13
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class Confidence {

    private String url;
    private Double confidence;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Double getConfidence()
    {
        return confidence;
    }

    public void setConfidence(Double confidence)
    {
        this.confidence = confidence;
    }

}
