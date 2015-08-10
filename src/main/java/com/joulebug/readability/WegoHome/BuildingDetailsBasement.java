package com.joulebug.readability.WegoHome;

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
"basement":
        {
        "sqft": 1000,
        "conditioned": false
        },
 */
public class BuildingDetailsBasement {
    private Integer sqft;
    private Boolean conditioned;

    public Integer getSqft() {
        return sqft;
    }

    public void setSqft(Integer sqft) {
        this.sqft = sqft;
    }

    public Boolean getConditioned() {
        return conditioned;
    }

    public void setConditioned(Boolean conditioned) {
        this.conditioned = conditioned;
    }

}
