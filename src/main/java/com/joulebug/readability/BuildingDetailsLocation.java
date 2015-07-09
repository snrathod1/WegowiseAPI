package com.joulebug.readability;

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
"location":
        {
        "city": "Boston",
        "climate_zone": "cold",
        "country": "United States",
        "county": "Suffolk",
        "state": "MA",
        "street_address": "1 Example Street",
        "zip_code": "02201"
        }
 */
public class BuildingDetailsLocation {
    private String city;
    private String climate_zone;
    private String country;
    private String county;
    private String state;
    private String street_address;
    private String zip_code;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClimate_zone() {
        return climate_zone;
    }

    public void setClimate_zone(String climate_zone) {
        this.climate_zone = climate_zone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
}
