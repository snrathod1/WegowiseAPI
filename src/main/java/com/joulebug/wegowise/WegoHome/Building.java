package com.joulebug.wegowise.WegoHome;

/**
 * Created by shraddharathod on 7/7/15.
 */

/**
 * {
 "address": "123 Main St, Boston, MA 02118",
 "nickname": "Main Street Apartments",
 "building_type": "sf_detached",
 "year_built": "2000",
 "construction": "wood_steel",
 "sqft": "1000",
 "has_basement": true,
 "basement_sqft": "200",
 "basement_conditioned": false,
 "n_stories": "2",
 "n_bedrooms": "12",
 "green_certified": false,
 "n_electric_general_meters": "1",
 "n_water_general_meters": "1",
 "n_gas_general_meters": "1",
 "n_oil_general_meters": "0",
 "heating_system": "furnace",
 "heating_fuel": "Gas",
 "cooling_system": "window_ac",
 "hot_water_fuel": "Solar",
 "hot_water_system": "other",
 "has_pool": "false",
 "has_laundry": "false",
 "notes": "notes",
 "draft": false
 }
 */
public class Building {
    private String address;
    private String nickname;
    private String building_type;
    private String year_built;
    private String construction;
    private String sqft;
    private Boolean has_basement;
    private String  basement_sqft;
    private Boolean basement_conditioned;
    private String n_stories;
    private String n_bedrooms;
    private Boolean green_certified;
    private String n_electric_general_meters;
    private String n_water_general_meters;
    private String n_gas_general_meters;
    private String n_oil_general_meters;
    private String heating_system;
    private String heating_fuel;
    private String cooling_system;
    private String hot_water_fuel;
    private String hot_water_system;
    private String has_pool;
    private String has_laundry;
    private String notes;
    private Boolean draft;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBuilding_type() {
        return building_type;
    }

    public void setBuilding_type(String building_type) {
        this.building_type = building_type;
    }

    public String getYear_built() {
        return year_built;
    }

    public void setYear_built(String year_built) {
        this.year_built = year_built;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }

    public Boolean getHas_basement() {
        return has_basement;
    }

    public void setHas_basement(Boolean has_basement) {
        this.has_basement = has_basement;
    }

    public String getBasement_sqft() {
        return basement_sqft;
    }

    public void setBasement_sqft(String basement_sqft) {
        this.basement_sqft = basement_sqft;
    }

    public Boolean getBasement_conditioned() {
        return basement_conditioned;
    }

    public void setBasement_conditioned(Boolean basement_conditioned) {
        this.basement_conditioned = basement_conditioned;
    }

    public String getN_stories() {
        return n_stories;
    }

    public void setN_stories(String n_stories) {
        this.n_stories = n_stories;
    }

    public String getN_bedrooms() {
        return n_bedrooms;
    }

    public void setN_bedrooms(String n_bedrooms) {
        this.n_bedrooms = n_bedrooms;
    }

    public Boolean getGreen_certified() {
        return green_certified;
    }

    public void setGreen_certified(Boolean green_certified) {
        this.green_certified = green_certified;

    }

    public String getN_electric_general_meters() {
        return n_electric_general_meters;
    }

    public void setN_electric_general_meters(String n_electric_general_meters) {
        this.n_electric_general_meters = n_electric_general_meters;
    }

    public String getN_water_general_meters() {
        return n_water_general_meters;
    }

    public void setN_water_general_meters(String n_water_general_meters) {
        this.n_water_general_meters = n_water_general_meters;
    }

    public String getN_gas_general_meters() {
        return n_gas_general_meters;
    }

    public void setN_gas_general_meters(String n_gas_general_meters) {
        this.n_gas_general_meters = n_gas_general_meters;
    }

    public String getN_oil_general_meters() {
        return n_oil_general_meters;
    }

    public void setN_oil_general_meters(String n_oil_general_meters) {
        this.n_oil_general_meters = n_oil_general_meters;
    }

    public String getHeating_system() {
        return heating_system;
    }

    public void setHeating_system(String heating_system) {
        this.heating_system = heating_system;
    }

    public String getHeating_fuel() {
        return heating_fuel;
    }

    public void setHeating_fuel(String heating_fuel) {
        this.heating_fuel = heating_fuel;
    }

    public String getCooling_system() {
        return cooling_system;
    }

    public void setCooling_system(String cooling_system) {
        this.cooling_system = cooling_system;
    }

    public String getHot_water_fuel() {
        return hot_water_fuel;
    }

    public void setHot_water_fuel(String hot_water_fuel) {
        this.hot_water_fuel = hot_water_fuel;
    }

    public String getHot_water_system() {
        return hot_water_system;
    }

    public void setHot_water_system(String hot_water_system) {
        this.hot_water_system = hot_water_system;
    }

    public String getHas_pool() {
        return has_pool;
    }

    public void setHas_pool(String has_pool) {
        this.has_pool = has_pool;
    }

    public String getHas_laundry() {
        return has_laundry;
    }

    public void setHas_laundry(String has_laundry) {
        this.has_laundry = has_laundry;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;

    }

}
