package com.joulebug.readability;

/**
 * Created by shraddharathod on 6/29/15.
 */
/*
{
    "coverage": "none",
    "data_type": "Gas",
    "for_heating": false,
    "id": 1,
    "notes": "Some notes",
    "utility_company":
      {
        "id": 1,
        "name": "UtilityCo1"
      }
  }
 */
public class WegoDataMeter {
    private String coverage;
    private String data_type;
    private Boolean for_heating;
    private Integer id;
    private String notes;
    private DataOnlyMeterUC utility_company;

    public String getCoverage(){
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getData_type(){
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public Boolean getFor_heating(){
        return for_heating;
    }

    public void setFor_heating(Boolean for_heating) {
        this.for_heating = for_heating;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes(){
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DataOnlyMeterUC getUtility_company(){
        return utility_company;
    }

    public void setUtility_company(DataOnlyMeterUC utility_company) {
        this.utility_company = utility_company;
    }

}
