package com.joulebug.readability;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by shraddharathod on 7/7/15.
 */
/*
{
    "id": 1,
    "buildings_count": 1,
    "coverage": 'all',
    "data_type": 'Gas',
    "for_heating": false,
    "notes": 'Some notes',
    "scope": 'HomeMeter',
    "utility_company": {
      "id": 23,
      "name": "Con Edison"
    }
  },
 */
public class HomeMeterList {
    private Integer id;
    private Integer buildings_count;
    private String coverage;
    private String data_type;
    private Boolean for_heating;
    private String notes;
    private String scope;
    private HomeMeterListUC utility_company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildings_count() {
        return buildings_count;
    }

    public void setBuildings_count(Integer buildings_count) {
        this.buildings_count = buildings_count;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getData_type() { return data_type; }

    public void setData_type(String data_type) { this.data_type = data_type;}
    public Boolean getFor_heating() {
        return for_heating;
    }

    public void setFor_heating(Boolean for_heating) {
        this.for_heating = for_heating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public HomeMeterListUC getUtility_company() {
        return utility_company;
    }

    public void setUtility_company(HomeMeterListUC utility_company) {
        this.utility_company = utility_company;
    }



}
