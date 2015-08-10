package com.joulebug.readability.WegoHome;

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
"hot_water":
        {
        "fuel": "Gas",
        "system": "Indirect hot water tank off boiler (Heat & DHW)"
        },
 */
public class BuildingDetailsHotWater {
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
