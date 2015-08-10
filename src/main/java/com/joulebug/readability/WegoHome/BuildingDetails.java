package com.joulebug.readability.WegoHome;

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
{
        "conditioned_sqft": 12000,
        "id": 1,
        "nickname": "The Big Building",
        "n_stories": 3,
        "sqft": 13000,
        "year_built": 1950,
        "type": "Low-rise apartment building",
        "basement":
        {
        "sqft": 1000,
        "conditioned": false
        },
        "cooling":
        {
        "system": "Window AC"
        },
        "heating":
        {
        "fuel": "Gas",
        "system": "Boiler (High-efficiency condensing)"
        },
        "hot_water":
        {
        "fuel": "Gas",
        "system": "Indirect hot water tank off boiler (Heat & DHW)"
        },
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
        }
*/
public class BuildingDetails {
    private Integer conditioned_sqft;
    private Integer id;
    private String nickname;
    private Integer n_stories;
    private Integer sqft;
    private Integer year_built;
    private String type;
    private BuildingDetailsBasement basement;
    private BuildingDetailsCooling cooling;
    private BuildingDetailsHeating heating;
    private BuildingDetailsHotWater hot_water;
    private BuildingDetailsLocation location;


    public Integer getConditioned_sqft() {
        return conditioned_sqft;
    }

    public void setConditioned_sqft(Integer conditioned_sqft) {
        this.conditioned_sqft = conditioned_sqft;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getN_stories() {
        return n_stories;
    }

    public void setN_stories(Integer n_stories) {
        this.n_stories = n_stories;
    }

    public Integer getSqft() {return sqft;}

    public void setSqft(Integer sqft) {
        this.sqft = sqft;
    }

    public Integer getYear_built() {
        return year_built;
    }

    public void setYear_built(Integer year_built) {
        this.year_built = year_built;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BuildingDetailsBasement getBasement() {
        return basement;
    }

    public void setBasement (BuildingDetailsBasement basement) {
        this.basement = basement;
    }

    public BuildingDetailsCooling getCooling() {
        return cooling;
    }

    public void setCooling (BuildingDetailsCooling cooling) {
        this.cooling = cooling;
    }

    public BuildingDetailsHeating getHeating() {
        return heating;
    }

    public void setHeating (BuildingDetailsHeating heating) {
        this.heating = heating;
    }

    public BuildingDetailsHotWater getHot_water() {
        return hot_water;
    }

    public void setHot_water (BuildingDetailsHotWater basement) {
        this.hot_water = hot_water;
    }

    public BuildingDetailsLocation getLocation() {
        return location;
    }

    public void setLocation (BuildingDetailsLocation location) {
        this.location = location;
    }

}
