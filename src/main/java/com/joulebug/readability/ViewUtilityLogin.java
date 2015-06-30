package com.joulebug.readability;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * Created by shraddharathod on 6/30/15.
 */
/*
{
    "id": 1,
    "status": "success",
    "username": "abcproperties",
    "utility_company": {
        "name": "NSTAR"
    },
    "account_numbers": [
        "abc123",
        "xyz987"
    ]
}
 */
public class ViewUtilityLogin {


    private Integer id;
    private String status;
    private String username;
    private ViewUtilityLoginUC utility_company;
    private String[] account_numbers;



    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;

    }

    public ViewUtilityLoginUC getUtility_company() {
        return utility_company;
    }

    public void setUtility_company (ViewUtilityLoginUC utility_company) {
        this.utility_company = utility_company;
    }

    public String[] getAccount_numbers() {
        return account_numbers;
    }

    public void setAccount_numbers(String[] account_numbers) {
        this.account_numbers = account_numbers;
    }
}
