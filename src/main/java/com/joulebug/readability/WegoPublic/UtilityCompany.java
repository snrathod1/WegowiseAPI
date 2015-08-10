package com.joulebug.readability.WegoPublic;

/**
 * Created by shraddharathod on 6/29/15.
 */
/*
{
    "id": 23,
    "data_type": "Gas",
    "name": "Con Edison",
    "short_name": "ConEd",
    "state_code": "PA"
  }
 */
public class UtilityCompany {
    private Integer id;
    private String data_type;
    private String name;
    private String short_name;
    private String state_code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }
}
