package com.joulebug.wegowise.WegoHome;

/**
 * Created by shraddharathod on 6/30/15.
 */
/*
{
    "username": "jane_smith",
    "password": "password123",
    "utility_company_id": 231
}
 */
public class CreateUtilityLogin {
    private String username;
    private String password;
    private String utility_company_id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUtility_company_id() {
        return utility_company_id;
    }

    public void setUtility_company_id(String utility_company_id) {
        this.utility_company_id = utility_company_id;
    }
}
