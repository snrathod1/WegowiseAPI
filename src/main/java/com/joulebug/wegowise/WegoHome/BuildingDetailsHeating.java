package com.joulebug.wegowise.WegoHome;

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
"heating":
        {
        "fuel": "Gas",
        "system": "Boiler (High-efficiency condensing)"
        },
 */
public class BuildingDetailsHeating {
    private String fuel;
    private String system;

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
